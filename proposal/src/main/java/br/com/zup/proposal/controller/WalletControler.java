package br.com.zup.proposal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.Wallet;
import br.com.zup.proposal.model.enums.WalletStatus;
import br.com.zup.proposal.provider.financial.request.WalletRequest;
import br.com.zup.proposal.repository.WalletRespository;
import br.com.zup.proposal.services.CardService;

@RestController
@RequestMapping("/wallets")
public class WalletControler {

	@Autowired
	private CardService cardService;

	@Autowired
	private WalletRespository walletRespository;

	@PostMapping("/{id}/wallet")
	public ResponseEntity<?> associeteWallet(@PathVariable Long id, @RequestBody WalletRequest request) {
		Card card = cardService.findById(id);

		WalletStatus status = cardService.consultAssociateWallet(card.getNumber(), request);

		Wallet wallet = new Wallet(request.getEmail(), request.getType(), status, card);

		walletRespository.save(wallet);

		return ResponseEntity.ok().build();
	}

}
