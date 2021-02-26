package br.com.zup.proposal.provider.financial.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockAnalysisRequest {

	@JsonProperty("sistemaResponsavel")
	private String sistemaResponsavel;

	public BlockAnalysisRequest(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

}
