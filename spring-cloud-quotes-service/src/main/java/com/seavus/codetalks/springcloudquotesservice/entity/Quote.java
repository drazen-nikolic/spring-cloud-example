package com.seavus.codetalks.springcloudquotesservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "popular_quotes")
@Data
public class Quote {
	
	public static Quote EMPTY = new Quote() {
		public String getText() { 
			return "Empty"; 
		};
	};

	@Id
	@GeneratedValue
	private Integer id;
	
	private String origin;
	private String text;
	
}
