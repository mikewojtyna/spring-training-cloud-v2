package pl.wojtyna.training.spring.cloud.crowdsorcery.notification;


import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.Event;

public interface NotificationService {

    void notifyAbout(Event event);
}
