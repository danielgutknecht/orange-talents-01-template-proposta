package br.com.zup.proposal.provider.financial.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.enums.TravelStatus;

public class TravelClientResponse {

	@JsonProperty("resultado")
	private TravelStatus resultado;
	
	
	public TravelStatus getResultado() {
		return resultado;
	}

	@Override
	public String toString() {
		return "TravelClientResponse [result=" + resultado + "]";
	}

}
