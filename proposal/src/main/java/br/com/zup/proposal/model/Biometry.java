package br.com.zup.proposal.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
public class Biometry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private UUID externalId = UUID.randomUUID();

	// @Column(nullable = false)
	private String text;

	@ManyToOne
	private Card card;

	public Biometry(String text, Card card) {
		this.text = text;
		this.card = card;
	}

	@Deprecated
	public Biometry() {

	}

	public boolean isBase64() {
		return Base64.isBase64(text.getBytes());
	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public String getText() {
		return text;
	}

	public Card getCard() {
		return card;
	}

}
