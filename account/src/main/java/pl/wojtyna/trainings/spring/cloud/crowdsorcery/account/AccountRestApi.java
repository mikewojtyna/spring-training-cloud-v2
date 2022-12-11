package pl.wojtyna.trainings.spring.cloud.crowdsorcery.account;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-module/api/v0/accounts")
public class AccountRestApi {

    @PutMapping("/{accountId}/amount")
    public void addOrLockFunds(@PathVariable("accountId") String accountId,
                               int amount) throws AccountOperationException {
        // TODO: implement internals
        throw new UnsupportedOperationException("Implement this method");
    }
}
