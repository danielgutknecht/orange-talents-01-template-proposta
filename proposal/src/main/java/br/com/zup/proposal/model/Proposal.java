package br.com.zup.proposal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import br.com.zup.proposal.model.enums.CardStatus;
import br.com.zup.proposal.model.enums.ProposalStatus;

@Entity
@Table(name = "proposta")
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

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

	@Column(nullable = false)
	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ProposalStatus status = ProposalStatus.ABERTA;

	@OneToOne
	private Card card;

	public Proposal(String name, String email, String document, BigDecimal salary, Address address) {
		this.name = name;
		this.email = email;
		this.document = document;
		this.salary = salary;
		this.address = address;
	}

	public Proposal(String name, String email, String document, BigDecimal salary, Address address,
			ProposalStatus status, Card card, CardStatus cardStatus) {
		this.name = name;
		this.email = email;
		this.document = document;
		this.salary = salary;
		this.address = address;
		this.status = status;
		this.card = card;
	}

	@Deprecated
	public Proposal() {
	}

	public void updateProposalStatus(ProposalStatus newStatus) {
		this.status = newStatus;

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
		return status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
