package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;

@Slf4j
public class CircuitBreakerAwareDelegatingInvestorProfileClient implements InvestorProfileClient {

    private final CircuitBreaker circuitBreaker;
    private final InvestorProfileClient delegate;

    public CircuitBreakerAwareDelegatingInvestorProfileClient(CircuitBreaker circuitBreaker,
                                                              InvestorProfileClient delegate) {
        this.circuitBreaker = circuitBreaker;
        this.delegate = delegate;
    }

    @Override
    public InvestorProfile profileOf(String id) {
        return circuitBreaker.run(() -> delegate.profileOf(id), exception -> defaultInvestorProfile());
    }

    private InvestorProfile defaultInvestorProfile() {
        log.warn("Investor profile service call failed. Returning default profile instead.");
        return new InvestorProfile(0, false, "https://wojtyna.pl?ref=DEFAULT_REF_LINK");
    }
}
