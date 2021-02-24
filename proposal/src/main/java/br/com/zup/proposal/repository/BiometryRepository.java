package br.com.zup.proposal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.proposal.model.Biometry;

@Repository
public interface BiometryRepository extends CrudRepository<Biometry, Long> {

}
