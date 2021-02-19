package br.com.zup.proposal.provider.financialAnalysis;

public class FinancialAnalysisResponse {

	private String name;

	private String document;

	private String proposalId;

	private String resultRequetAnalisis;

	public FinancialAnalysisResponse(String name, String document, String proposalId, String resultRequetAnalisis) {
		this.name = name;
		this.document = document;
		this.proposalId = proposalId;
		this.resultRequetAnalisis = resultRequetAnalisis;
	}

	public String getName() {
		return name;
	}

	public String getDocument() {
		return document;
	}

	public String getProposalId() {
		return proposalId;
	}

	public String getResultRequetAnalisis() {
		return resultRequetAnalisis;
	}

}
