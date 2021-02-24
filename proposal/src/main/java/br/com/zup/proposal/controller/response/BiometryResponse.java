package br.com.zup.proposal.controller.response;

import java.util.UUID;

import br.com.zup.proposal.model.Biometry;

public class BiometryResponse {

	private Long id;

	private UUID externalId;

	private String text;

	private CardResponse cardResponse;

	public BiometryResponse(Biometry biometry) {
		this.id = biometry.getId();
		this.externalId = biometry.getExternalId();
		this.text = biometry.getText();
		this.cardResponse = new CardResponse(biometry.getCard());
	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public String getText() {
		return text;
	}

	public CardResponse getCardResponse() {
		return cardResponse;
	}

}
