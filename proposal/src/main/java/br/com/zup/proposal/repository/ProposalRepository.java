package br.com.zup.proposal.repository;

import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    Optional<Proposal> findByDocument(String document);

    Boolean existsByDocument(String document);

    Optional<Proposal> findByExternalId(UUID externalId);

    Optional<Proposal> findAllByStatusAndCard(ProposalStatus status, Card card);

}
