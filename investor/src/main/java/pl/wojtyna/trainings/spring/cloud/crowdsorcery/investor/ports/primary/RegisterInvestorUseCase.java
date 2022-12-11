package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.Investor;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorEvent;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorRegistered;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorEventPublisher;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorProfileService;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorRepository;

public class RegisterInvestorUseCase {

    private final InvestorProfileService investorProfileService;
    private final InvestorRepository investorRepository;
    private final InvestorEventPublisher eventPublisher;

    public RegisterInvestorUseCase(InvestorProfileService investorProfileService,
                                   InvestorRepository investorRepository,
                                   InvestorEventPublisher eventPublisher) {
        this.investorProfileService = investorProfileService;
        this.investorRepository = investorRepository;
        this.eventPublisher = eventPublisher;
    }

    public void register(RegisterInvestor command) {
        var investor = new Investor(command.id(),
                                    command.name(),
                                    investorProfileService.fetchById(command.id()).orElseThrow(), command.version());
        investorRepository.save(investor);
        // we should use outbox pattern here, but let's leave it like this for the sake of the simplicity
        InvestorEvent event = new InvestorRegistered(investor);
        eventPublisher.publish(event);
    }
}
