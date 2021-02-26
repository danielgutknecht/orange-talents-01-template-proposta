package br.com.zup.proposal.controller;

import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.enums.CardStatus;
import br.com.zup.proposal.provider.financial.request.BlockAnalysisRequest;
import br.com.zup.proposal.model.Block;
import br.com.zup.proposal.repository.BlockRepository;
import br.com.zup.proposal.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cards")
public class BlockController {

	@Autowired
	private CardService cardService;

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	BlockRepository blockRepository;

	@PostMapping("/{id}/block")

	public ResponseEntity<?> lockcard(@PathVariable Long id, @RequestBody String sistemaResponsavel) {

		Card card = cardService.findById(id);

		if (card.isBlocked()) {
			return ResponseEntity.unprocessableEntity()
					.body(new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Card already blocked"));
		}

		CardStatus status = cardService.consultCardStatus(card.getNumber(),
				new BlockAnalysisRequest(sistemaResponsavel));

		String userAgent = servletRequest.getHeader("User-Agent");
		String ipClient = servletRequest.getHeader("X-FORWARDED-FOR");

		if (ipClient == null || "".equals(ipClient)) {
			ipClient = servletRequest.getRemoteAddr();
		}

		Block block = new Block(ipClient, userAgent, card);

		blockRepository.save(block);

		card.updateCardStatus(status);

		cardService.save(card);

		return ResponseEntity.ok().build();
	}
}
