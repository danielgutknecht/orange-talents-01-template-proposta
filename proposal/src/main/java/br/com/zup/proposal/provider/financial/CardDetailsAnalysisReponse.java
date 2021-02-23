package br.com.zup.proposal.provider.financial;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetailsAnalysisReponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("emitidoEm")
	private LocalDateTime createdAt;

	@JsonProperty("titular")
	private String cardHolderName;

	private List<CardLockedResponse> CardLocked;

	public CardDetailsAnalysisReponse(String id, LocalDateTime createdAt, String cardHolderName,
			List<CardLockedResponse> cardLocked) {
		this.id = id;
		this.createdAt = createdAt;
		this.cardHolderName = cardHolderName;
		CardLocked = cardLocked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public List<CardLockedResponse> getCardLocked() {
		return CardLocked;
	}

	public void setCardLocked(List<CardLockedResponse> cardLocked) {
		CardLocked = cardLocked;
	}

}
