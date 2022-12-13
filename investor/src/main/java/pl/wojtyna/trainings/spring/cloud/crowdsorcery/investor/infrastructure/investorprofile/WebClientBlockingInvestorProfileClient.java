package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile;

import org.springframework.web.reactive.function.client.WebClient;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;

public class WebClientBlockingInvestorProfileClient implements InvestorProfileClient {

    private final WebClient webClient;

    public WebClientBlockingInvestorProfileClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public InvestorProfile profileOf(String id) {
        return webClient.get()
                        .uri("http://investor-profile/investor-profile-module/api/v0/profiles/{id}", id)
                        .retrieve()
                        .bodyToMono(InvestorProfile.class)
                        .blockOptional().orElseThrow();
    }
}
