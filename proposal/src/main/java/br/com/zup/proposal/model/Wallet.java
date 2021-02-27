package br.com.zup.proposal.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import br.com.zup.proposal.model.enums.WalletStatus;
import br.com.zup.proposal.model.enums.WalletType;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	private WalletType type;

	@Enumerated(EnumType.STRING)
	private WalletStatus status = WalletStatus.NAO_ASSOCIADA;

	@OneToOne
	private Card card;

	@Deprecated
	public Wallet() {

	}

	public Wallet(String email, WalletType type, WalletStatus status, Card card) {
		this.email = email;
		this.type = type;
		this.status = status;
		this.card = card;
	}

	public boolean isAssociete() {
		return this.status == WalletStatus.ASSOCIADA;

	}

	public void updateWalletType(WalletType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getEmail() {
		return email;
	}

	public WalletType getType() {
		return type;
	}

	public WalletStatus getStatus() {
		return status;
	}

	public Card getCard() {
		return card;
	}

}
