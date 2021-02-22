package br.com.zup.proposal.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposal.controller.request.ProposalRequest;
import br.com.zup.proposal.controller.response.ProposalResponse;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.provider.financial.FinancialAnalysisRequest;
import br.com.zup.proposal.services.ProposalService;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

	@Autowired
	private ProposalService proposalService;

	@PostMapping
	public ResponseEntity<ProposalResponse> createProposal(@RequestBody @Valid ProposalRequest request,
			UriComponentsBuilder uriBuilder) {

		Proposal newProposal = request.toProposal();

		proposalService.existsProposalByDocument(newProposal.getDocument());

		proposalService.create(newProposal);

		ProposalStatus status = proposalService.consultProposal(new FinancialAnalysisRequest(newProposal));

		newProposal.updateProposalStatus(status);

		proposalService.create(newProposal);

		
		URI location = uriBuilder.path("/propostas/{id}").buildAndExpand(newProposal.getId()).toUri();

		return ResponseEntity.created(location).body(new ProposalResponse(newProposal));
	}

}
