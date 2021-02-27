package br.com.zup.proposal.controller;

import javax.servlet.http.HttpServletRequest;
import br.com.zup.proposal.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.Travel;
import br.com.zup.proposal.provider.financial.CardClient;
import br.com.zup.proposal.provider.financial.request.TravelClientRequest;
import br.com.zup.proposal.provider.financial.response.TravelClientResponse;
import br.com.zup.proposal.services.CardService;

@RestController
@RequestMapping("travels")
public class TravelController {

	@Autowired
	private CardService cardService;

	@Autowired
	private TravelRepository travelRepository;

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private CardClient client;

	@PostMapping("/{id}/notification")
	public ResponseEntity<?> travelNotification(@PathVariable Long id, @RequestBody TravelClientRequest request) {
		Card card = cardService.findById(id);

		if (card.isBlocked()) {
			return ResponseEntity.unprocessableEntity()
					.body(new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Card already blocked"));
		}

		TravelClientResponse status = client.consultTravelNotification(card.getNumber(), request);

		String userAgent = servletRequest.getHeader("User-Agent");
		String ipClient = servletRequest.getHeader("X-FORWARDED-FOR");

		if (ipClient == null || "".equals(ipClient)) {
			ipClient = servletRequest.getRemoteAddr();
		}

		Travel travel = new Travel(userAgent, ipClient, request.getDestino(), request.getValidoAte(), card);

		travel.updateTravelStatus(status.getResultado());

		travelRepository.save(travel);

		return ResponseEntity.ok().build();
	}

}
