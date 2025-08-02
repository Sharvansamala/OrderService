package com.sharvan.OrderService.OrderService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced //discovers services by name using Eureka or other service discovery mechanisms
    // This annotation allows the RestTemplate to use Ribbon for client-side load balancing
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
