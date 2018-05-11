package com.seavus.codetalks.springcloudquotesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.seavus.codetalks.springcloudquotesservice.repository.QuotesRepository;
import com.seavus.codetalks.springcloudquotesservice.service.QuotesService;
import com.seavus.codetalks.springcloudquotesservice.service.QuotesServiceImpl;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class SpringCloudQuotesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudQuotesServiceApplication.class, args);
	}
	
	@Bean
	public QuotesService quotesService(QuotesRepository repository) {
		return new QuotesServiceImpl(repository);
	}
}
