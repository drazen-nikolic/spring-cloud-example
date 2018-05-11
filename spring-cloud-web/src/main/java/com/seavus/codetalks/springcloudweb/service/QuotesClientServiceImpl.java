package com.seavus.codetalks.springcloudweb.service;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seavus.codetalks.springcloudweb.model.Quote;
import com.seavus.codetalks.springcloudweb.model.QuoteResult;
import com.seavus.codetalks.springcloudweb.model.ServerInfo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuotesClientServiceImpl implements QuotesClientService {
	
	private static final String FALLBACK_QUOTE = "\"Life always offers you a second chance. It's called tomorrow!\"";
	
	private RestTemplate restTemplate;
	
    @HystrixCommand(fallbackMethod = "fallbackQuoteResult")
	public QuoteResult getQuoteResult() {
		return restTemplate.getForObject("http://quotes-service/quotes", QuoteResult.class);
	}
    
	public QuoteResult fallbackQuoteResult() {
    	QuoteResult result = new QuoteResult();
    	result.setQuote(new Quote(0, "fallback", FALLBACK_QUOTE));
    	result.setServerInfo(new ServerInfo("-1 (fallback)"));
    	return result;
    }
}
