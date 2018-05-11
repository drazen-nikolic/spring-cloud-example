package com.seavus.codetalks.springcloudquotesservice.service;

import java.util.Optional;

import com.seavus.codetalks.springcloudquotesservice.entity.Quote;

public interface QuotesService {
	Optional<Quote> getQuote();
	Optional<Quote> getQuoteFromOrigin(String origin);
}
