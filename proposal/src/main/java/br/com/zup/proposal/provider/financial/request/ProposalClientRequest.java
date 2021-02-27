package br.com.zup.proposal.provider.financial.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.Proposal;

public class ProposalClientRequest {

	@JsonProperty("documento")
	private final String document;

	@JsonProperty("nome")
	private final String name;

	@JsonProperty("idProposta")
	private final Long idProposal;

	public ProposalClientRequest(Proposal proposal) {
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
