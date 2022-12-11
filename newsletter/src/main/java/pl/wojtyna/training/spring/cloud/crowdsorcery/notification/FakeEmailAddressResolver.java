package pl.wojtyna.training.spring.cloud.crowdsorcery.notification;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.CrowdSorceryUser;

public class FakeEmailAddressResolver implements EmailAddressResolver {

    private final String fakeDomain;

    public FakeEmailAddressResolver(String fakeDomain) {
        this.fakeDomain = fakeDomain;
    }

    @Override
    public String resolveAddressOf(CrowdSorceryUser user) {
        return "%s@%s".formatted(user.name(), fakeDomain);
    }
}
