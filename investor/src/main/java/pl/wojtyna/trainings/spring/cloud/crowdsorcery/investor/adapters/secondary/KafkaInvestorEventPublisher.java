package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.InvestorEvent;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorEventPublisher;

public class KafkaInvestorEventPublisher implements InvestorEventPublisher {

    @Override
    public void publish(InvestorEvent event) {
        // TODO: implement
    }
}
