package br.com.zup.proposal.provider.financial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "financialAnalysis", url = "${proposal.client.financialanalysis.url}")
public interface FinancialAnalysisClient {

	@PostMapping("/api/solicitacao")
	public FinancialAnalysisResponse consult(@RequestBody FinancialAnalysisRequest financialAnalysisRequest);
	

}
