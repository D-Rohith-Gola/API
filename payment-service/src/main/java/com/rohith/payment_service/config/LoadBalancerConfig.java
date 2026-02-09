package com.rohith.payment_service.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class LoadBalancerConfig {

    @Bean
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new ServiceInstanceListSupplier() {

            @Override
            public String getServiceId() {
                return "order-service";
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                return Flux.just(List.of(
                    new DefaultServiceInstance(
                        "order-1",
                        "order-service",
                        "localhost",
                        8081,
                        false
                    ),
                    new DefaultServiceInstance(
                        "order-2",
                        "order-service",
                        "localhost",
                        8082,
                        false
                    )
                ));
            }
        };
    }
}
