package com.wbs.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "DefectPreventionPlan")
public class DefectPreventionPlan extends AuditEntity {
	
	private int projectId;
	private String defectTypeAndDetails;
	private String preventionPlan;
	private String currentStatus;

}
