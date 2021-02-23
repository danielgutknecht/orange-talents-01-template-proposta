package br.com.zup.proposal.repository;

import br.com.zup.proposal.model.Card;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	Optional<Card> findByExternalId(UUID externalId);

}
