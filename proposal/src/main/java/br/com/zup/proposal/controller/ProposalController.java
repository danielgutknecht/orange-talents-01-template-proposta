package br.com.zup.proposal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.proposal.controller.request.ProposalRequest;
import br.com.zup.proposal.controller.response.ProposalResponse;
import br.com.zup.proposal.model.Proposal;
import br.com.zup.proposal.model.enums.ProposalStatus;
import br.com.zup.proposal.services.ProposalService;

@RestController
@RequestMapping("/proposals")
public class ProposalController {
	
	@Autowired
	private ProposalService proposalService;
	
		
	@PostMapping
	public ResponseEntity<ProposalResponse> createProposal(@RequestBody @Valid ProposalRequest request) {
		
		Proposal newProposal = request.toProposal();
		
		proposalService.existsProposalByDocument(newProposal.getDocument());
		
		ProposalStatus status = proposalService.consultProposal(newProposal);
		
		newProposal.updateProposalStatus(status);
		
		proposalService.create(newProposal);
		
		return ResponseEntity.ok().body(new ProposalResponse(newProposal));
	}

}
