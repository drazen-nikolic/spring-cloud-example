package com.seavus.codetalks.springcloudquotesservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.seavus.codetalks.springcloudquotesservice.entity.Quote;
import com.seavus.codetalks.springcloudquotesservice.repository.QuotesRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuotesServiceImpl implements QuotesService {

	private final QuotesRepository repository;
	
	@Override
	public Optional<Quote> getQuote() {
		return Optional.ofNullable(getRandomQuote(repository.findAll()));
	}

	@Override
	public Optional<Quote> getQuoteFromOrigin(String origin) {
		return Optional.ofNullable(getRandomQuote(repository.findByOrigin(origin)));
	}
	
	private Quote getRandomQuote(List<Quote> quotes) {
		if (quotes != null && quotes.size() > 0) {
			Random random = new Random();
			return quotes.get(random.nextInt(quotes.size()));
		} else {
			return null;
		}
	}

}
