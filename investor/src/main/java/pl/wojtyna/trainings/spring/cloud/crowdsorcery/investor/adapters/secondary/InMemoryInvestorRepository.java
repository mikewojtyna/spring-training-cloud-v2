package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.adapters.secondary;

import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.domain.Investor;
import pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.ports.secondary.InvestorRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryInvestorRepository implements InvestorRepository {

    private final ConcurrentMap<String, Investor> investors = new ConcurrentHashMap<>();

    @Override
    public void save(Investor investor) {
        investors.put(investor.id(), investor);
    }

    @Override
    public List<Investor> findAll() {
        return List.copyOf(investors.values());
    }
}
