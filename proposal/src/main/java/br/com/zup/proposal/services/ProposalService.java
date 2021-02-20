package br.com.zup.proposal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.provider.financial.FinancialAnalysisClient;
import br.com.zup.proposal.provider.financial.FinancialAnalysisResponse;
import br.com.zup.proposal.repository.ProposalRepository;
import feign.FeignException.FeignClientException;

@Service
public class ProposalService {

	@Autowired
	private ProposalRepository proposalRepository;

	
	private FinancialAnalysisClient financialAnalysisClient;
	
	@Autowired
	public ProposalService(FinancialAnalysisClient fianAnalysisClient) {
		this.financialAnalysisClient = fianAnalysisClient;
	}

	public Boolean existsProposalByDocument(String document) {

		Boolean documentExists = proposalRepository.existsByDocument(document);
		if (documentExists != null) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
					"There is already a proposal for that document.");
		}

		return documentExists;
	}

	public ProposalStatus consultProposal(Proposal newProposal) {

		try {
			FinancialAnalysisResponse proposalAnalises = financialAnalysisClient.consult(
					newProposal.getDocument(),
					newProposal.getName(), 
					newProposal.getId());

			return proposalAnalises.getResultadoSolicitaca();

		} catch (FeignClientException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao analisar a solicitação. Tente novamente.", e.getCause());
		}

	}

	public Proposal create(Proposal proposal) {
		return proposalRepository.save(proposal);
	}

}
