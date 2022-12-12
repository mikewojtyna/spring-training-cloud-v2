package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.eureka;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaConfiguration {

    @Bean
    public FetchInvestorProfileInstances fetchInvestorProfileInstances(DiscoveryClient discoveryClient) {
        return new FetchInvestorProfileInstances(discoveryClient);
    }
}
