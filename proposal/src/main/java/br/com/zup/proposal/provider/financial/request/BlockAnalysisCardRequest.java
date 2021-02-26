package br.com.zup.proposal.provider.financial.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockAnalysisCardRequest {

	@JsonProperty("sistemaResponsavel")
	private String responsibleSystem;

	public BlockAnalysisCardRequest(String responsibleSystem) {
		this.responsibleSystem = responsibleSystem;
	}

	public String getResponsibleSystem() {
		return responsibleSystem;
	}

}
