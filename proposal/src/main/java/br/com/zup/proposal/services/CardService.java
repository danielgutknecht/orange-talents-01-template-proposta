package br.com.zup.proposal.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.provider.financial.CardAnalysisClient;
import br.com.zup.proposal.provider.financial.CardAnalysisResponse;
import br.com.zup.proposal.repository.CardRepository;
import br.com.zup.proposal.repository.ProposalRepository;
import feign.FeignException;

@Service
@EnableScheduling
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private ProposalRepository proposalRepository;

	@Autowired
	private CardAnalysisClient cardAnalysisClient;

	@Scheduled(fixedDelay = 1000) // 1min 20000 - 10min 600000milli
	@Transactional
	public void scheduleConsulCardFromProposalEligible() {

		List<Proposal> proposalList = proposalRepository.findTopByStatusOrderByCreatedAtAsc(ProposalStatus.ELEGIVEL);

		proposalList.forEach(proposal -> {

			CardAnalysisResponse response = consulCardFromProposal(proposal.getId());

			Card card = new Card(response.getCardNumber(), response.getLimit(), proposal);

			cardRepository.save(card);
			proposal.updateProposalStatus(ProposalStatus.CARTAO_ASSOCIADO);
			proposal.setCard(card);
			proposalRepository.save(proposal);

		});
	}

	public CardAnalysisResponse consulCardFromProposal(Long id) {

		try {
			CardAnalysisResponse response = cardAnalysisClient.consulById(id);
			return response;

		} catch (FeignException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Card not found to proposal",
					e.getCause());
		}
	}
}
