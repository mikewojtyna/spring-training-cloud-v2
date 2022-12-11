package pl.wojtyna.training.spring.cloud.crowdsorcery.notification;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.CrowdSorceryUser;

public interface EmailAddressResolver {

    String resolveAddressOf(CrowdSorceryUser user);
}
