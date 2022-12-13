package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.investorprofile;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorProfile;

public interface InvestorProfileClient {

    InvestorProfile profileOf(String id);
}
