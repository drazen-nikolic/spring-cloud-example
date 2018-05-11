package com.seavus.codetalks.springcloudquotesservice.endpoint;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServerInfo {
	private String port;
}
