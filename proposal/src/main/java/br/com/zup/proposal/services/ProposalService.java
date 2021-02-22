package br.com.zup.proposal.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.provider.financial.FinancialAnalysisClient;
import br.com.zup.proposal.provider.financial.FinancialAnalysisRequest;
import br.com.zup.proposal.provider.financial.FinancialAnalysisResponse;
import br.com.zup.proposal.repository.ProposalRepository;
import feign.FeignException.FeignClientException;

@Service
public class ProposalService {

	@Autowired
	private ProposalRepository proposalRepository;

	@Autowired
	private FinancialAnalysisClient financialAnalysisClient;

	public Boolean existsProposalByDocument(String document) {

		Boolean documentExists = proposalRepository.existsByDocument(document);
		if (documentExists.equals(document)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
					"There is already a proposal for that document.");
		}

		return documentExists;
	}

	public ProposalStatus consultProposal(FinancialAnalysisRequest financialAnalysisRequest) {

		try {
			FinancialAnalysisResponse proposalAnalises = financialAnalysisClient.consult(financialAnalysisRequest);

			System.out.println(proposalAnalises.toString());

			return proposalAnalises.getResultadoSolicitaca();

		} catch (FeignClientException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao analisar a solicitação. Tente novamente.", e.getCause());
		}

	}

	@Transactional
	public Proposal create(Proposal proposal) {
		return proposalRepository.save(proposal);
	}

}
