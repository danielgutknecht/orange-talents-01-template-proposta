package br.com.zup.proposal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.proposal.model.Wallet;

@Repository
public interface WalletRespository extends JpaRepository<Wallet, Long> {

}
