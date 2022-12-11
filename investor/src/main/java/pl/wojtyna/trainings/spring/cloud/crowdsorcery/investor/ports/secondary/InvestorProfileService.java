package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;

import java.util.Optional;

public interface InvestorProfileService {

    Optional<InvestorProfile> fetchById(String id);
}
