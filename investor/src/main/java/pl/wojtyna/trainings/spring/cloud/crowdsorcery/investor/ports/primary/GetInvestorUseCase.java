package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.Investor;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorRepository;

import java.util.Optional;

public class GetInvestorUseCase {

    private final InvestorRepository investorRepository;

    public GetInvestorUseCase(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public Optional<Investor> getInvestor(String id) {
        return investorRepository.findById(id);
    }
}
