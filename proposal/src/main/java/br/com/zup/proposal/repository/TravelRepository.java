package br.com.zup.proposal.repository;

import br.com.zup.proposal.model.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {

}
