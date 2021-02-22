package br.com.zup.proposal.provider.financial;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.zup.proposal.model.enums.ProposalStatus;

public class FinancialAnalysisResponse {

	@JsonProperty
	private String documento;

	@JsonProperty
	private String nome;

	@JsonProperty
	private ProposalStatus resultadoSolicitacao;

	@JsonProperty
	private Long idProposta;

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public ProposalStatus getResultadoSolicitaca() {
		return resultadoSolicitacao;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	@Override
	public String toString() {
		return "FinancialAnalysisResponse [documento=" + documento + ", nome=" + nome + ", resultadoSolicitaca="
				+ resultadoSolicitacao + ", idProposta=" + idProposta + "]";
	}

}
