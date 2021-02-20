package br.com.zup.proposal.model.enums;

public enum ProposalStatus {

	ELEGIVEL("SEM_RESTRICAO"), 
	
	NAO_ELEGIVEL("COM_RESTRICAO"), 
	
	CARTAO_ASSOCIADO("ASSOCIADO");

	private String description;

	ProposalStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static ProposalStatus toEnum(String analysisResult) {
		if (analysisResult == null)
			return null;

		for (ProposalStatus status : ProposalStatus.values()) {
			if (status.getDescription().equals(analysisResult))
				return status;
		}

		throw new IllegalArgumentException("No status description has been entered for " + analysisResult);
	}

}
