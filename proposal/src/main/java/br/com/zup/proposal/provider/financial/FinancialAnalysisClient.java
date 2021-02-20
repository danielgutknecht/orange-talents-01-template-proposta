package br.com.zup.proposal.provider.financial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "financialAnalysis", url = "${proposal.client.financialanalysis.url}")
public interface FinancialAnalysisClient {

	@PostMapping("/api/solicitacao")
	public FinancialAnalysisResponse consult(String documento, String nome, Long idProposta);

}
