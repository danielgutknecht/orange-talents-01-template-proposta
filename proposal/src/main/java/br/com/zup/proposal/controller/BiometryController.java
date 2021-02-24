package br.com.zup.proposal.controller;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.proposal.controller.request.BiometryRequest;
import br.com.zup.proposal.controller.response.BiometryResponse;
import br.com.zup.proposal.model.Biometry;
import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.repository.BiometryRepository;
import br.com.zup.proposal.repository.CardRepository;

@RestController
@RequestMapping("/biometrics")
public class BiometryController {

	@Autowired
	private BiometryRepository biometryRepository;

	@Autowired
	private CardRepository cardRepository;

	@PostMapping("{id}")
	public ResponseEntity<?> createBiometry(@PathVariable Long id, @RequestBody @Valid BiometryRequest request,
			UriComponentsBuilder uriBuilder) {

		Card card = cardRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Card not found."));

		Biometry biometry = request.toBiometry(request.getText(), card);
		if (biometry.isBase64() != true) {
			return ResponseEntity
					.ok(new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Biometry isn't base64"));
		}

		biometryRepository.save(biometry);

		URI location = uriBuilder.path("/biometrics/{id}").buildAndExpand(biometry.getId()).toUri();
		return ResponseEntity.created(location).body(new BiometryResponse(biometry));
	}

}
