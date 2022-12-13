package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.eureka;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;

public class EurekaConfiguration {

    @Bean
    public FetchInvestorProfileInstances fetchInvestorProfileInstances(DiscoveryClient discoveryClient) {
        return new FetchInvestorProfileInstances(discoveryClient);
    }
}
