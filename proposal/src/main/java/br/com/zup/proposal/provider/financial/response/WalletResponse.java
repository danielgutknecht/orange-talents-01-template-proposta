package br.com.zup.proposal.provider.financial.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.enums.WalletStatus;

public class WalletResponse {

	@JsonProperty("resultado")
	private WalletStatus status;

	@JsonProperty("id")
	private String id;

	public WalletStatus getStatus() {
		return status;
	}

	public String getId() {
		return id;
	}

}
