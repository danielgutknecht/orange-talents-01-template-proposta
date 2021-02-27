package br.com.zup.proposal.provider.financial.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TravelClientRequest {

	@JsonProperty("destino")
	private String destino;

	@JsonProperty("validoAte")
	private LocalDate validoAte;

	public TravelClientRequest(String destino, LocalDate validoAte) {
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

}
