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

	//@Document
	@Column(nullable = false, unique = true)
	private String document;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String name;

	@Embedded
	@Column(nullable = false)
	private Address address;

	@Positive(message = "Salary can't be negative")
	@Column(nullable = false)
	private BigDecimal salary;


	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ProposalStatus status = ProposalStatus.NOT_ELIGIBLE;

	@OneToOne
	private Card card;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private CardStatus cardStatus = CardStatus.UNCREATED;

	public Proposal(String document, String email, String name, Address address, BigDecimal salary) {
		this.document = document;
		this.email = email;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Deprecated
	public Proposal() {
	}

	public void associateCard(Card card) {
		this.card = card;
		this.cardStatus = CardStatus.CREATED;
	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public String getDocument() {
		return document;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public ProposalStatus getStatus() {
		return status;
	}

	public Card getCard() {
		return card;
	}

	public CardStatus getCardStatus() {
		return cardStatus;
	}

	public void setStatus(ProposalStatus status) {
		this.status = status;
	}

}
