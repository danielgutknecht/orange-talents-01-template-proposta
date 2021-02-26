package br.com.zup.proposal.controller.response;

import java.math.BigDecimal;
import java.util.UUID;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;

public class ProposalResponse {

	private UUID externalId;

	private String name;

	private String email;

	private BigDecimal salary;

	private String document;

	private ProposalStatus status;

	private AddressResponse addressResponse;

	public ProposalResponse(Proposal proposal) {
		this.externalId = proposal.getExternalId();
		this.name = proposal.getName();
		this.email = proposal.getEmail();
		this.salary = proposal.getSalary();
		this.document = proposal.getDocument();
		this.status = proposal.getProposalStatus();
		this.addressResponse = new AddressResponse(proposal.getAddress());

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

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

}
