package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.primary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.Versionable;

public record InvestorFetchResultRestDto(String id, String name, int version) implements Versionable {
}
