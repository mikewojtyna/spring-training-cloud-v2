package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investorprofile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/investor-profile-module/api/v0/profiles")
@Slf4j
public class InvestorProfileRestApi {

    @GetMapping("/{id}")
    public Optional<InvestorProfileRestDto> getProfile(@PathVariable("id") String id) throws InterruptedException {
        simulateSomeRandomDelay();
        return Optional.of(new InvestorProfileRestDto(25, true, "https://wojtyna.pl?ref=7890"));
    }

    private void simulateSomeRandomDelay() throws InterruptedException {
        long waitSeconds = new Random().nextInt(10);
        log.info("Waiting for {} seconds.", waitSeconds);
        TimeUnit.SECONDS.sleep(waitSeconds);
    }
}
