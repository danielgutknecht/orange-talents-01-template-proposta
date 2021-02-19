package br.com.zup.proposal.controller.request;

import br.com.zup.proposal.model.Address;

public class AddressRequest {

	private String cep;

	private String street;

	private String district;

	private String complement;

	private String city;

	private String state;

	public AddressRequest(String cep, String street, String district, String complement, String city, String state) {
		this.cep = cep;
		this.street = street;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
	}

	public Address toAddress() {
		return new Address(cep, street, district, complement, city, state);
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