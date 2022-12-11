package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary.InMemoryInvestorRepository;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary.KafkaInvestorEventPublisher;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary.RestApiClientInvestorProfileService;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary.RegisterInvestorUseCase;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorEventPublisher;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorProfileService;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorRepository;

@Configuration
public class InvestorModuleConfiguration {

    @Bean
    public InvestorProfileService investorProfileService() {
        return new RestApiClientInvestorProfileService();
    }

    @Bean
    public InvestorRepository investorRepository() {
        return new InMemoryInvestorRepository();
    }

    @Bean
    public RegisterInvestorUseCase registerInvestorUseCase(InvestorRepository investorRepository,
                                                           InvestorProfileService investorProfileService,
                                                           InvestorEventPublisher eventPublisher) {
        return new RegisterInvestorUseCase(investorProfileService, investorRepository, eventPublisher);
    }

    @Bean
    public InvestorEventPublisher investorEventPublisher() {
        return new KafkaInvestorEventPublisher();
    }
}
