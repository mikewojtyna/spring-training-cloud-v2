package pl.wojtyna.training.spring.cloud.crowdsorcery.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;

@Configuration
public class NotificationModuleConfiguration {

    @Bean
    public EmailAddressResolver emailAddressResolver() {
        return new FakeEmailAddressResolver("wojtyna.pl");
    }

    @Bean
    @Profile({"prod", "default"})
    public NotificationService mailNotificationService(MailSender mailSender,
                                                       EmailAddressResolver emailAddressResolver) {
        return new SimpleMailNotificationService(mailSender, emailAddressResolver);
    }

    @Bean
    @Profile({"test", "demo"})
    public NotificationService stubbedNotificationService() {
        return event -> {};
    }
}
