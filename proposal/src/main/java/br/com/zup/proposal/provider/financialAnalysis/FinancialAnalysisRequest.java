package br.com.zup.proposal.provider.financialAnalysis;

public class FinancialAnalysisRequest {

	private Long proposalId;

	private String document;

	private String name;

	public FinancialAnalysisRequest(Long proposalId, String document, String name) {
		this.proposalId = proposalId;
		this.document = document;
		this.name = name;
	}

	public Long getProposalId() {
		return proposalId;
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

}
