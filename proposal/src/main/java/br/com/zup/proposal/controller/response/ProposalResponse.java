package br.com.zup.proposal.controller.response;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.CardStatus;
import br.com.zup.proposal.model.enums.ProposalStatus;

public class ProposalResponse {

	private UUID externalId;

	private String name;

	private String email;

	private BigDecimal salary;

	private String document;

	private ProposalStatus status;

	private CardStatus cardStatus;

	public ProposalResponse(Proposal proposal) {
		this.name = proposal.getName();
		this.email = proposal.getEmail();
		this.salary = proposal.getSalary();
		this.document = proposal.getDocument();
		this.status = proposal.getStatus();
		this.cardStatus = proposal.getCardStatus();
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

	public BigDecimal getSalary() {
		return salary;
	}

	public String getDocument() {
		return document;
	}

	public ProposalStatus getStatus() {
		return status;
	}

	public CardStatus getCardStatus() {
		return cardStatus;
	}

}
