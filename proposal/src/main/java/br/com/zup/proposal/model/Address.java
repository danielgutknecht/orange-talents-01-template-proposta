package br.com.zup.proposal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String district;

	@Column()
	private String complement;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	public Address(String cep, String street, String district, String complement, String city, String state) {
		this.cep = cep;
		this.street = street;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
	}

	@Deprecated
	public Address() {
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
