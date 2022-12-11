package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investorprofile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/investor-profile-module/api/v0/profiles")
public class InvestorProfileRestApi {

    @GetMapping("/{id}")
    public Optional<InvestorProfileRestDto> getProfile(@PathVariable("id") String id) {
        return Optional.of(new InvestorProfileRestDto(25, true, "https://wojtyna.pl?ref=7890"));
    }
}
