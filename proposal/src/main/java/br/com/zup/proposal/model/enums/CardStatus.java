package br.com.zup.proposal.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardStatus {

	BLOQUEADO("BLOQUEADO"), ATIVO("ATIVO");

	private String description;

	CardStatus(String description) {
		this.description = description;
	}

	@JsonValue
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
