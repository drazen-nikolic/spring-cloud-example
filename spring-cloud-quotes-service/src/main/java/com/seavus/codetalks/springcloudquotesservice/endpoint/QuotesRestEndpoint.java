package com.seavus.codetalks.springcloudquotesservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seavus.codetalks.springcloudquotesservice.entity.Quote;
import com.seavus.codetalks.springcloudquotesservice.service.QuotesService;

@RestController
@RefreshScope
public class QuotesRestEndpoint {

	@Autowired
	private QuotesService service;
	
	@Value("${quote.origin}")
	private String origin;
	
	@Autowired
	Environment environment;
	
    @RequestMapping(value = "/quotes", produces = "application/json")
    public QuoteResult getQuote() {
    	Quote quote = service.getQuoteFromOrigin(origin).orElse(Quote.EMPTY);
    	return QuoteResult.builder()
    			.quote(quote)
    			.serverInfo(ServerInfo.builder()
    					.port(environment.getProperty("local.server.port"))
    					.build())
    			.build();
    }
    
    
}
