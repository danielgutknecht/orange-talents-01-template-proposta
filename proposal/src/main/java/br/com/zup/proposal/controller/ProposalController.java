package br.com.zup.proposal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.proposal.controller.request.ProposalRequest;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.provider.financialAnalysis.FinancialAnalysisClient;
import br.com.zup.proposal.repository.ProposalRepository;

@RestController
@RequestMapping("/proposals")
public class ProposalController {
	
	@Autowired
	private ProposalRepository proposalRepository;
	
	@Autowired
	private FinancialAnalysisClient analisisClient;
	
	
	
	@PostMapping
	public ResponseEntity<?> createProposal(@RequestBody @Valid ProposalRequest request) {
		
		Proposal newProposal = request.toProposal();
		
		return null;
	}

}
