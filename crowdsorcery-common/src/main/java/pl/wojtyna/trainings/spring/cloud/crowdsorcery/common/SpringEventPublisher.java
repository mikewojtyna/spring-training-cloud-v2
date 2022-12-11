package pl.wojtyna.trainings.spring.cloud.crowdsorcery.common;

import org.springframework.context.ApplicationEventPublisher;

public class SpringEventPublisher<E extends Event> implements EventPublisher<E> {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(E event) {
        applicationEventPublisher.publishEvent(event);
    }
}
