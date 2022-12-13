package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class InvestorProfileIntegrationConfiguration {

    @Bean
    public InvestorProfileClient investorProfileClient(CircuitBreakerFactory<?, ?> circuitBreakerFactory,
                                                       WebClient webClient) {
        return new CircuitBreakerAwareDelegatingInvestorProfileClient(circuitBreakerFactory.create(
            "fetchInvestorProfile"), new WebClientBlockingInvestorProfileClient(webClient));
    }
}
