package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorProfileService;

import java.util.Optional;

public class RestApiClientInvestorProfileService implements InvestorProfileService {

    @Override
    public Optional<InvestorProfile> fetchById(String id) {
        // TODO: implement
        throw new UnsupportedOperationException("TODO: Implement");
    }
}
