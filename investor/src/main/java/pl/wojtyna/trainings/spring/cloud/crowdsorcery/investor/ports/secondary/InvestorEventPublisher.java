package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.EventPublisher;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorEvent;

public interface InvestorEventPublisher extends EventPublisher<InvestorEvent> {

}
