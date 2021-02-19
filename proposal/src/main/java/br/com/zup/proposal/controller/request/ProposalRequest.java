package br.com.zup.proposal.controller.request;

import br.com.zup.proposal.model.Proposal;
import java.math.BigDecimal;

public class ProposalRequest {

	private String name;

	private String email;

	private String document;

	private BigDecimal salary;

	private AddressRequest address;

	public Proposal toProposal() {
		return new Proposal(name, email, document, salary, address.toAddress());
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

	public AddressRequest getAddress() {
		return address;
	}

}
