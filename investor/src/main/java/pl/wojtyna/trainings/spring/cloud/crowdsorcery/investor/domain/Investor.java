package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.CrowdSorceryUser;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.Versionable;

public record Investor(String id, String name, InvestorProfile investorProfile,
                       int version) implements CrowdSorceryUser, Versionable {
}
