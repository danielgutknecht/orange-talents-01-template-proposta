package br.com.zup.proposal.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Positive;

import br.com.zup.proposal.model.enums.CardStatus;
import br.com.zup.proposal.model.enums.ProposalStatus;

@Entity
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private final UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	// @Document
	@Column(nullable = false, unique = true)
	private String document;

	@Positive(message = "Salary can't be negative")
	@Column(nullable = false)
	private BigDecimal salary;
	@Embedded

	@Column(nullable = false)
	private Address address;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ProposalStatus proposalStatus;

	@OneToOne
	private Card card;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private CardStatus cardStatus;

	public Proposal(String name, String email, String document, BigDecimal salary, Address address) {
		this.name = name;
		this.email = email;
		this.document = document;
		this.salary = salary;
		this.address = address;

	}

	@Deprecated
	public Proposal() {
	}

	public void associateCard(Card card) {
		this.card = card;
		this.cardStatus = CardStatus.CREATED;
	}

	public void updateProposalStatus(ProposalStatus newStatus) {
		this.proposalStatus = newStatus;

	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDocument() {
		return document;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Address getAddress() {
		return address;
	}

	public ProposalStatus getProposalStatus() {
		return proposalStatus;
	}

	public Card getCard() {
		return card;
	}

	public CardStatus getCardStatus() {
		return cardStatus;
	}

}
