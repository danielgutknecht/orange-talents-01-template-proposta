package br.com.zup.proposal.controller.response;

import br.com.zup.proposal.model.Address;

public class AddressResponse {

	private String cep;

	private String street;

	private String district;

	private String complement;

	private String city;

	private String state;

	public AddressResponse(Address address) {
		this.cep = address.getCep();
		this.street = address.getStreet();
		this.district = address.getDistrict();
		this.complement = address.getComplement();
		this.city = address.getCity();
		this.state = address.getState();
	}

	public String getCep() {
		return cep;
	}

	public String getStreet() {
		return street;
	}

	public String getDistrict() {
		return district;
	}

	public String getComplement() {
		return complement;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

}
