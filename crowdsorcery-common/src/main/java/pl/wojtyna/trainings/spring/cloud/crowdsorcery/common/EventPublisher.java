package pl.wojtyna.trainings.spring.cloud.crowdsorcery.common;

public interface EventPublisher<E extends Event> {

    void publish(E event);
}
