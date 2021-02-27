package br.com.zup.proposal.provider.financial.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockClientRequest {

	@JsonProperty("sistemaResponsavel")
	private String responsibleSystem;

	public BlockClientRequest(String responsibleSystem) {
		this.responsibleSystem = responsibleSystem;
	}

	public String getResponsibleSystem() {
		return responsibleSystem;
	}

}
