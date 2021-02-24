package br.com.zup.proposal.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.proposal.model.Biometry;
import br.com.zup.proposal.model.Card;

public class BiometryRequest {

	// @NotBlank
	private String text;

	private Long cardId;

	public Biometry toBiometry(String text, Card card) {
		return new Biometry(text, card);
	}

	public String getText() {
		return text;
	}

	public Long getCardId() {
		return cardId;
	}

}
