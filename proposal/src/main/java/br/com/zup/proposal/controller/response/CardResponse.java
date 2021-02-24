package br.com.zup.proposal.controller.response;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.zup.proposal.model.Card;

public class CardResponse {

	private Long id;

	private UUID externalId = UUID.randomUUID();

	private String cardNumber;

	private LocalDateTime createdAt;

	public CardResponse(Card card) {
		this.id = card.getId();
		this.externalId = card.getExternalId();
		this.cardNumber = card.getNumber();
		this.createdAt = card.getCreatedAt();
	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
