package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.Command;

public record RegisterInvestor(String id, String name, int version) implements Command {
}
