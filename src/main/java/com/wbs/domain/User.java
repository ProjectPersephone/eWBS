package com.wbs.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Users")
public class User extends AuditEntity {
	
	private String username;
	
	private String password;
	
	private String resource;
	
	private String role;
	
}
