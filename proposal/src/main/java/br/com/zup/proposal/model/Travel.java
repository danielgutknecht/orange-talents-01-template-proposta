package br.com.zup.proposal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.proposal.model.enums.TravelStatus;

@Entity
public class Travel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private final UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private final LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false)
	private String userAgent;

	@Column(nullable = false)
	private String ipCliente;

	@Column(nullable = false)
	private String destiny;

	// @Column(nullable = false)
	private LocalDate validateAt;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TravelStatus status = TravelStatus.NAO_CRIADO;

	@ManyToOne
	private Card card;

	@Deprecated
	public Travel() {

	}

	public Travel(String userAgent, String ipCliente, String destiny, LocalDate validateAt, Card card) {
		this.userAgent = userAgent;
		this.ipCliente = ipCliente;
		this.destiny = destiny;
		this.validateAt = validateAt;
		this.card = card;
	}

	public void updateTravelStatus(TravelStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public UUID getExternalId() {
		return externalId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getDestiny() {
		return destiny;
	}

	public LocalDate getValidateAt() {
		return validateAt;
	}

	public TravelStatus getStatus() {
		return status;
	}

	public Card getCard() {
		return card;
	}

}
