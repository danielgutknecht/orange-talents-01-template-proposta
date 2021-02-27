package br.com.zup.proposal.services;

import java.util.List;
import java.util.UUID;
import br.com.zup.proposal.model.enums.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.proposal.model.Card;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.model.enums.WalletStatus;
import br.com.zup.proposal.provider.financial.CardClient;
import br.com.zup.proposal.provider.financial.request.BlockClientRequest;
import br.com.zup.proposal.provider.financial.request.TravelClientRequest;
import br.com.zup.proposal.provider.financial.request.WalletRequest;
import br.com.zup.proposal.provider.financial.response.BlockClientResponse;
import br.com.zup.proposal.provider.financial.response.CardClientResponse;
import br.com.zup.proposal.provider.financial.response.TravelClientResponse;
import br.com.zup.proposal.provider.financial.response.WalletResponse;
import br.com.zup.proposal.repository.CardRepository;
import br.com.zup.proposal.repository.ProposalRepository;
import feign.FeignException;

@Service
@EnableScheduling // <-- active Scheduler
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private ProposalRepository proposalRepository;

	@Autowired
	private CardClient cardClient;

	@Scheduled(fixedDelay = 2000) // 1min 20000 - 10min 600000milli
	@Transactional
	public void scheduleConsulCardFromProposalEligible() {

		List<Proposal> proposalList = proposalRepository.findTopByStatusOrderByCreatedAtAsc(ProposalStatus.ELEGIVEL);

		proposalList.forEach(proposal -> {

			CardClientResponse response = cardClient.consulById(proposal.getId());

			Card card = new Card(response.getCardNumber(), response.getLimit(), proposal);

			cardRepository.save(card);
			proposal.updateProposalStatus(ProposalStatus.CARTAO_ASSOCIADO);
			proposal.setCard(card);
			proposalRepository.save(proposal);

		});
	}

	@Transactional(timeout = 5000)
	public CardClientResponse consulCardFromProposal(Long id) {
		try {
			CardClientResponse response = cardClient.consulById(id);
			return response;
		} catch (FeignException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Card not found to proposal",
					e.getCause());
		}
	}

	public CardStatus consultBlockCardStatus(String id, BlockClientRequest request) {

		try {

			BlockClientResponse responseStatus = cardClient.solicitationBlock(id, request);

			System.out.println(responseStatus.toString());

			return responseStatus.getResultado();

		} catch (FeignException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Block card status can't be processable",
					e.getCause());
		}
	}

	public TravelClientResponse consultNotificationCardStatus(String id, TravelClientRequest request) {

		try {

			TravelClientResponse responseStatus = cardClient.consultTravelNotification(id, request);

			System.out.println(responseStatus.toString());

			return responseStatus;

		} catch (FeignException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Travel status can't be processable",
					e.getCause());
		}
	}

	public WalletStatus consultAssociateWallet(String id, WalletRequest request) {

		try {

			WalletResponse responseStatus = cardClient.associeteWallet(id, request);

			System.out.println(responseStatus.toString());

			return responseStatus.getStatus();

		} catch (FeignException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Card status can't be processable",
					e.getCause());
		}
	}

	public Card findById(Long id) {
		return cardRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Card not found"));
	}

	public Card findByUUID(UUID uuid) {
		return cardRepository.findByExternalId(uuid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UUID Card not found"));
	}

	@Transactional
	public Card save(Card card) {
		return cardRepository.save(card);
	}

}
