package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile.InvestorProfileClient;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorProfileService;

import java.util.Optional;

public class InvestorProfileClientService implements InvestorProfileService {

    private final InvestorProfileClient client;

    public InvestorProfileClientService(InvestorProfileClient client) {
        this.client = client;
    }

    @Override
    public Optional<InvestorProfile> fetchById(String id) {
        return Optional.of(client.profileOf(id));
    }
}
