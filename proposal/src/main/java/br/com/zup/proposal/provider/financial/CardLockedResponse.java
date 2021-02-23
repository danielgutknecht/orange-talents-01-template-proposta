package br.com.zup.proposal.provider.financial;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardLockedResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("bloqueadoEm")
	private LocalDateTime lockedAt;

	@JsonProperty("sistemaResponsavel")
	private String responsibleSystem;

	@JsonProperty("ativo")
	private boolean active;

	public CardLockedResponse(String id, LocalDateTime lockedAt, String responsibleSystem, boolean active) {
		this.id = id;
		this.lockedAt = lockedAt;
		this.responsibleSystem = responsibleSystem;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getLockedAt() {
		return lockedAt;
	}

	public String getResponsibleSystem() {
		return responsibleSystem;
	}

	public boolean isActive() {
		return active;
	}

}
