package br.com.zup.proposal.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private final UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	// @Column(nullable = false)
	private String ipClient;

	// @Column(nullable = false)
	private String userAgent;

	@OneToOne
	private Card card;

	@Deprecated
	public Block() {

	}

	public Block(String ipClient, String userAgent, Card card) {
		this.ipClient = ipClient;
		this.userAgent = userAgent;
		this.card = card;
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

	public String getIpClient() {
		return ipClient;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Card getCard() {
		return card;
	}

	@Override
	public String toString() {
		return "Block [id=" + id + ", externalId=" + externalId + ", createdAt=" + createdAt + ", ipClient=" + ipClient
				+ ", userAgent=" + userAgent + ", card=" + card + "]";
	}

}
