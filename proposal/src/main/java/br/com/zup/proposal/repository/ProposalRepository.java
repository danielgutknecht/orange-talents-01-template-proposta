package br.com.zup.proposal.repository;

import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;

import org.hibernate.LockOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

	Optional<Proposal> findByDocument(String document);

	Boolean existsByDocument(String document);

	Optional<Proposal> findByExternalId(UUID externalId);

	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({ @QueryHint(name = "javax.persistence.lock.timeout", value = (LockOptions.SKIP_LOCKED + "")) })
	List<Proposal> findTopByStatusOrderByCreatedAtAsc(ProposalStatus status);
	
}
