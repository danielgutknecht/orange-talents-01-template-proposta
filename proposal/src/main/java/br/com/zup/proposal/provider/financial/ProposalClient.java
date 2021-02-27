package br.com.zup.proposal.provider.financial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zup.proposal.provider.financial.request.ProposalClientRequest;
import br.com.zup.proposal.provider.financial.response.ProposalClientResponse;


@FeignClient(name = "financialAnalysis", url = "${proposal.client.financialanalysis.url}")
public interface ProposalClient {

	@PostMapping("/api/solicitacao")
	public ProposalClientResponse consult(@RequestBody ProposalClientRequest financialAnalysisRequest);
	

}
