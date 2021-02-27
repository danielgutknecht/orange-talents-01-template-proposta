package br.com.zup.proposal.provider.financial.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.enums.CardStatus;

public class BlockClientResponse {

	@JsonProperty("resultado")
	private CardStatus result;
	
	public CardStatus getResultado() {
		return result;
	}

	@Override
	public String toString() {
		return "CardLockAnalysisResponse [resultado=" + result + "]";
	}

}
