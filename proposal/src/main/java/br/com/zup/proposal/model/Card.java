package br.com.zup.proposal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.com.zup.proposal.model.enums.CardStatus;

@Entity
@Table(name = "cartao")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private UUID externalId = UUID.randomUUID();

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private BigDecimal creditLimit;

	@Enumerated(EnumType.STRING)
	private CardStatus cardStatus = CardStatus.ATIVO;

	@OneToOne
	private Proposal proposal;

	@OneToMany(mappedBy = "card")
	private Set<Biometry> biometry;

	public Card(String number, BigDecimal limit, Proposal proposal) {
		this.number = number;
		this.creditLimit = limit;
		this.proposal = proposal;
	}

	@Deprecated
	public Card() {
	}

	public void updateCardStatus(CardStatus status) {
		this.cardStatus = status;
	}

	public boolean isBlocked() {
		return this.cardStatus == CardStatus.BLOQUEADO;
	}

	public void isActive(Card card) {
		this.cardStatus = CardStatus.ATIVO;
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

	public String getNumber() {
		return number;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public CardStatus getCardStatus() {
		return cardStatus;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public Set<Biometry> getBiometry() {
		return biometry;
	}

}
