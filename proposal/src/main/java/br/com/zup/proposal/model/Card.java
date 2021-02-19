package br.com.zup.proposal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@OneToOne
	private Proposal proposal;

	public Card(String number, LocalDateTime createdAt, Proposal proposal) {
		this.number = number;
		this.createdAt = createdAt;
		this.proposal = proposal;
	}

	@Deprecated
	public Card() {
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Proposal getProposal() {
		return proposal;
	}

}
