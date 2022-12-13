package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Slf4j
public class FetchInvestorProfileInstances implements ApplicationRunner {

    private final DiscoveryClient discoveryClient;

    public FetchInvestorProfileInstances(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        discoveryClient.getInstances("investor-profile")
                       .forEach(serviceInstance -> log.info("Found investor profile service instance: {}",
                                                            serviceInstance));
    }
}
