package br.com.zup.proposal.provider.financial.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardClientResponse {

	@JsonProperty("id")
	private String cardNumber;

	@JsonProperty("emitidoEm")
	private LocalDateTime createdAt;

	@JsonProperty("titular")
	private String cardHolderName;

	@JsonProperty("limite")
	private BigDecimal creditLimit;

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public BigDecimal getLimit() {
		return creditLimit;
	}

}
