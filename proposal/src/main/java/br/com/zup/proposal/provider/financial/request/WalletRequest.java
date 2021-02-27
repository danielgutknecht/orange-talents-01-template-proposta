package br.com.zup.proposal.provider.financial.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposal.model.enums.WalletType;

public class WalletRequest {

	@JsonProperty("email")
	private String email;

	@JsonProperty("carteira")
	private WalletType type;

	public WalletRequest(String email, WalletType type) {
		this.email = email;
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public WalletType getType() {
		return type;
	}

}
