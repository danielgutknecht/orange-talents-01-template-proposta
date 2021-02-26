package br.com.zup.proposal.provider.financial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.zup.proposal.provider.financial.request.BlockAnalysisRequest;
import br.com.zup.proposal.provider.financial.response.BlockAnalysisResponse;
import br.com.zup.proposal.provider.financial.response.CardAnalysisResponse;

@FeignClient(name = "card", url = "${card.url}")
@RequestMapping("/api")
public interface CardAnalysisClient {

	@GetMapping("/cartoes")
	CardAnalysisResponse consulById(@PathVariable("id") Long id);

	@PostMapping("/cartoes/{id}/bloqueios")
	BlockAnalysisResponse solicitationBlockCard(@PathVariable String id, @RequestBody BlockAnalysisRequest request);

}
