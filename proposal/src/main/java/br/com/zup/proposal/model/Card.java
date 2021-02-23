package br.com.zup.proposal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartao")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private BigDecimal creditLimit;

	@OneToOne
	private Proposal proposal;

	public Card(String number, BigDecimal limit, Proposal proposal) {
		this.number = number;
		this.creditLimit = limit;
		this.proposal = proposal;
	}

	@Deprecated
	public Card() {
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

	public String getNumber() {
		return number;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public Proposal getProposal() {
		return proposal;
	}

}
