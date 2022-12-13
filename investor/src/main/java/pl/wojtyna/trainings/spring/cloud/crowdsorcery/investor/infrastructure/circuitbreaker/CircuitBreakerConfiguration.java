package pl.wojtyna.trainings.spring.cloud.crowdsorcery.investor.infrastructure.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

public class CircuitBreakerConfiguration {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> resilience4JConfiguration() {
        return resilience4JCircuitBreakerFactory -> resilience4JCircuitBreakerFactory.configureDefault(id -> new Resilience4JConfigBuilder(
            id).timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(5)).build())
               .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
               .build());
    }
}
