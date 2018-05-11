package com.seavus.codetalks.springcloudquotesservice.endpoint;

import com.seavus.codetalks.springcloudquotesservice.entity.Quote;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteResult {
	private Quote quote;
	private ServerInfo serverInfo;
}
