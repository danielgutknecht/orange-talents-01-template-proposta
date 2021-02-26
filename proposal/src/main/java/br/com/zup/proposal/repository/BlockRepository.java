package br.com.zup.proposal.repository;

import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.Block;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {
	Optional<Block> findByCard(Card card);
}
