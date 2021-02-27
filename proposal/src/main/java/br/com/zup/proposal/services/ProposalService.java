package br.com.zup.proposal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.provider.financial.ProposalClient;
import br.com.zup.proposal.provider.financial.request.ProposalClientRequest;
import br.com.zup.proposal.provider.financial.response.ProposalClientResponse;
import br.com.zup.proposal.repository.ProposalRepository;
import feign.FeignException.FeignClientException;

@Service
public class ProposalService {

	@Autowired
	private ProposalRepository proposalRepository;

	@Autowired
	private ProposalClient proposalClientService;

	public void findByDocument(String document) {
		Optional<Proposal> existDocument = proposalRepository.findByDocument(document);
		if (existDocument.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
					"There is already a proposal for that document.");
		}

	}

	public ProposalStatus consultProposal(ProposalClientRequest financialAnalysisRequest) {

		try {
			ProposalClientResponse proposalAnalises = proposalClientService.consult(financialAnalysisRequest);

			// System.out.println(proposalAnalises.toString());

			return proposalAnalises.getResultadoSolicitacao();

		} catch (FeignClientException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao analisar a solicitação. Tente novamente.", e.getCause());
		}

	}

	public Proposal create(Proposal proposal) {
		return proposalRepository.save(proposal);
	}

	public Proposal findById(Long id) {
		return proposalRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Proposal not found"));
	}

}
