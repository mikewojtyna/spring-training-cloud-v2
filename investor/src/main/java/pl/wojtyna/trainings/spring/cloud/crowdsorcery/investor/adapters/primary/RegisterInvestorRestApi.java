package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary.RegisterInvestor;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.primary.RegisterInvestorUseCase;

import java.net.URI;

@RestController
@RequestMapping("/investor-module/api/v0/investors")
public class RegisterInvestorRestApi {

    private final RegisterInvestorUseCase registerInvestorUseCase;

    public RegisterInvestorRestApi(RegisterInvestorUseCase registerInvestorUseCase) {
        this.registerInvestorUseCase = registerInvestorUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterInvestorErrorResponse> register(@RequestBody RegisterInvestorRestDto registerInvestorRestDto) {
        registerInvestorUseCase.register(new RegisterInvestor(registerInvestorRestDto.id(),
                                                              registerInvestorRestDto.name(),
                                                              registerInvestorRestDto.version()));
        return ResponseEntity.created(URI.create("/investor-module/api/v0/investors/%s".formatted(
                                 registerInvestorRestDto.id())))
                             .build();
    }

    private record RegisterInvestorErrorResponse(RegisterInvestorRestDto command, String reason) {

    }
}
