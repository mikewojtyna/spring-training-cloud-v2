package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.primary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.Versionable;

public record UpdateInvestorRestDto(String name, int version) implements Versionable {
}
