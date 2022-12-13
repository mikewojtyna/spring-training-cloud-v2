package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary;

import org.springframework.web.reactive.function.client.WebClient;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorProfileService;

import java.util.Optional;

public class WebClientLoadBalancedInvestorProfileService implements InvestorProfileService {

    private final WebClient webClient;

    public WebClientLoadBalancedInvestorProfileService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Optional<InvestorProfile> fetchById(String id) {
        return webClient.get()
                        .uri("http://investor-profile/investor-profile-module/api/v0/profiles/{id}", id)
                        .retrieve()
                        .bodyToMono(InvestorProfile.class)
                        .blockOptional();
    }
}
