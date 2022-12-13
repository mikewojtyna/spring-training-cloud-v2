package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.primary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.Investor;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary.GetInvestorUseCase;

import java.util.Optional;

@RestController
@RequestMapping("/investor-module/api/v0/investors/{id}")
public class GetInvestorRestApi {

    private final GetInvestorUseCase getInvestorUseCase;

    public GetInvestorRestApi(GetInvestorUseCase getInvestorUseCase) {
        this.getInvestorUseCase = getInvestorUseCase;
    }

    @GetMapping
    public Optional<Investor> getInvestor(@PathVariable("id") String id) {
        return getInvestorUseCase.getInvestor(id);
    }
}
