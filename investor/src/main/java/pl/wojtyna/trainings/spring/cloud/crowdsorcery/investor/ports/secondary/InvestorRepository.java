package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.Investor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface InvestorRepository {

    void save(Investor investor);

    List<Investor> findAll();

    default Optional<Investor> findById(String id) {
        return findAll().stream().filter(investor -> Objects.equals(investor.id(), id)).findAny();
    }
}
