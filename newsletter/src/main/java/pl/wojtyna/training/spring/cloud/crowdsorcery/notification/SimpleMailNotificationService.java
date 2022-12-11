package pl.wojtyna.training.spring.cloud.crowdsorcery.notification;

import org.springframework.mail.MailSender;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.common.Event;

public class SimpleMailNotificationService implements NotificationService {

    private final MailSender mailSender;
    private final EmailAddressResolver emailAddressResolver;

    public SimpleMailNotificationService(MailSender mailSender, EmailAddressResolver emailAddressResolver) {
        this.mailSender = mailSender;
        this.emailAddressResolver = emailAddressResolver;
    }

    @Override
    public void notifyAbout(Event event) {
        // TODO: handle investor registered event here. How would you integrate with investor module events?

        /*if (event instanceof InvestorRegistered investorRegistered) {
            var message = new SimpleMailMessage();
            message.setSubject("Investor profile is registered!");
            message.setText("Your investor profile is registered");
            message.setTo(emailAddressResolver.resolveAddressOf(investorRegistered.investor()));
            mailSender.send(message);
        }*/
    }
}
