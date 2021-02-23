package br.com.zup.proposal.provider.financial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cardCreation", url = "${proposal.client.card-creation.url}")
public interface CardAnalysisClient {
	
	@GetMapping("/api/cartoes")
	CardAnalysisResponse consulById(@PathVariable("id") Long id);
}
