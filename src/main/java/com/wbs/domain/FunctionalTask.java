package com.wbs.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "FunctionalTask")
public class FunctionalTask extends AuditEntity {
	private String projectName;
	
	private int projectPlanningAndTrackingPlanned;
	private int projectPlanningAndTrackingActual;
	private String projectPlanningAndTrackingRemarks;
	
	private int riskManagementPlanned;
	private int riskManagementActual;
	private String riskManagementRemarks;
	
	private int changeManagementPlanned;
	private int changeManagementActual;
	private String changeManagementRemarks;
	
	private int sizePlanned;
	private int sizeActual;
	private String sizeRemarks;
	
	private int storyPointsPlanned;
	private int storyPointsActual;
	private String storyPointsRemarks;

}
