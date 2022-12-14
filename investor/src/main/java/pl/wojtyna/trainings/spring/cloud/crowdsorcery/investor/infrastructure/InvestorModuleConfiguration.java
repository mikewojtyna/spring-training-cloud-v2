package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary.InMemoryInvestorRepository;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary.InvestorProfileClientService;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary.KafkaInvestorEventPublisher;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.circuitbreaker.CircuitBreakerConfiguration;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.eureka.EurekaConfiguration;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile.InvestorProfileClient;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile.InvestorProfileIntegrationConfiguration;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary.GetInvestorUseCase;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary.RegisterInvestorUseCase;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorEventPublisher;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorProfileService;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorRepository;

@Configuration
@Import({EurekaConfiguration.class, CircuitBreakerConfiguration.class, InvestorProfileIntegrationConfiguration.class})
public class InvestorModuleConfiguration {

    @Bean
    public InvestorProfileService investorProfileService(InvestorProfileClient investorProfileClient) {
        return new InvestorProfileClientService(investorProfileClient);
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

    @Bean
    public WebClient webClient(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        return WebClient.builder()
                        .filter(loadBalancerExchangeFilterFunction)
                        .build();
    }

    @Bean
    public GetInvestorUseCase getInvestorUseCase(InvestorRepository investorRepository) {
        return new GetInvestorUseCase(investorRepository);
    }
}
