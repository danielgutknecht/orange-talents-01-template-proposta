package br.com.zup.proposal.controller.response;

import java.time.LocalDateTime;

import br.com.zup.proposal.model.Card;

public class CardResponse {

	private String cardNumber;

	private LocalDateTime createdAt;

	public CardResponse(Card card) {
		this.cardNumber = card.getNumber();
		this.createdAt = card.getCreatedAt();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
