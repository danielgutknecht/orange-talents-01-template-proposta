package br.com.zup.proposal.provider.financial.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetailsClientReponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("emitidoEm")
	private LocalDateTime createdAt;

	@JsonProperty("titular")
	private String cardHolderName;

	private List<BlockClientResponse> CardLocked;

	public CardDetailsClientReponse(String id, LocalDateTime createdAt, String cardHolderName,
			List<BlockClientResponse> cardLocked) {
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

	public List<BlockClientResponse> getCardLocked() {
		return CardLocked;
	}

	public void setCardLocked(List<BlockClientResponse> cardLocked) {
		CardLocked = cardLocked;
	}

}
