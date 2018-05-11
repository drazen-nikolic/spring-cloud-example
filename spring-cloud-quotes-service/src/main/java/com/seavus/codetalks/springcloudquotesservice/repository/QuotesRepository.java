package com.seavus.codetalks.springcloudquotesservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seavus.codetalks.springcloudquotesservice.entity.Quote;

@Transactional
public interface QuotesRepository extends JpaRepository<Quote, Integer> {
	public List<Quote> findByOrigin(String origin);
}
