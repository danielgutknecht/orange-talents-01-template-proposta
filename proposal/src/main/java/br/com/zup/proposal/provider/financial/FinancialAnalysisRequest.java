package br.com.zup.proposal.provider.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.Proposal;

public class FinancialAnalysisRequest {

	@JsonProperty("documento")
	private final String document;

	@JsonProperty("nome")
	private final String name;

	@JsonProperty("idProposta")
	private final Long idProposal;

	public FinancialAnalysisRequest(Proposal proposal) {
		this.document = proposal.getDocument();
		this.name = proposal.getName();
		this.idProposal = proposal.getId();
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public Long getIdProposal() {
		return idProposal;
	}

}
