package com.seavus.codetalks.springcloudweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
	private Integer id;
	private String origin;
	private String text;
}
