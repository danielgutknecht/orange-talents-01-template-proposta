package br.com.zup.proposal.provider.financial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.zup.proposal.provider.financial.request.BlockClientRequest;
import br.com.zup.proposal.provider.financial.request.TravelClientRequest;
import br.com.zup.proposal.provider.financial.request.WalletRequest;
import br.com.zup.proposal.provider.financial.response.BlockClientResponse;
import br.com.zup.proposal.provider.financial.response.CardClientResponse;
import br.com.zup.proposal.provider.financial.response.TravelClientResponse;
import br.com.zup.proposal.provider.financial.response.WalletResponse;

@FeignClient(name = "card", url = "${card.url}")
@RequestMapping("/api/cartoes")
public interface CardClient {

	@GetMapping
	CardClientResponse consulById(@PathVariable("id") Long id);

	@PostMapping("{id}/bloqueios")
	BlockClientResponse solicitationBlock(@PathVariable String id, @RequestBody BlockClientRequest request);

	@PostMapping("{id}/avisos")
	TravelClientResponse consultTravelNotification(@PathVariable String id, @RequestBody TravelClientRequest request);

	@PostMapping("{id}/carteiras")
	WalletResponse associeteWallet(@PathVariable String id, @RequestBody WalletRequest request);

}
