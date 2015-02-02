package com.wbs.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "CausalAnalysis")
public class CausalAnalysis extends AuditEntity {
	
	private String projectName;
	private String causeOfBug;
	private int totalNoOfDefects;
	private String correctiveActionTaken;
	private String preventiveActionPlanned;

}
