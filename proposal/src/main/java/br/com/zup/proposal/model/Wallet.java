package br.com.zup.proposal.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private final UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private final LocalDateTime createdAt = LocalDateTime.now();

	@ManyToOne
	private Card card;

}
