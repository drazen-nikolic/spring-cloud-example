package com.seavus.codetalks.springcloudweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.seavus.codetalks.springcloudweb.service.QuotesClientService;
import com.seavus.codetalks.springcloudweb.service.QuotesClientServiceImpl;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringCloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudWebApplication.class, args);
    }
    
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }

    @Bean
    public QuotesClientService service(RestTemplate restTemplate) {
    	return new QuotesClientServiceImpl(restTemplate);
    }
}
