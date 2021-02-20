package br.com.zup.proposal.provider.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;

public class FinancialAnalysisResponse {

	@JsonProperty
	private String documento;

	@JsonProperty
	private String nome;

	@JsonProperty
	private ProposalStatus resultadoSolicitaca;

	@JsonProperty
	private Long idProposta;

	public FinancialAnalysisResponse(Proposal proposal) {
		this.documento = proposal.getDocument();
		this.nome = proposal.getName();
		this.resultadoSolicitaca = proposal.getProposalStatus();
		this.idProposta = proposal.getId();
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public ProposalStatus getResultadoSolicitaca() {
		return resultadoSolicitaca;
	}

	public Long getIdProposta() {
		return idProposta;
	}

}
