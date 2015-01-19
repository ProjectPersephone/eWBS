package com.wbs.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "DefectAndDPReviewBugs")
public class DefectAndDPReviewBugs extends AuditEntity {
	
	private int requirementsCriticalDefects;
	private int requirementsMajorDefects;
	private int requirementsMinorDefects;
	private int requirementsSuggestions;
	
	private int analysisCriticalDefects;
	private int analysisMajorDefects;
	private int analysisMinorDefects;
	private int analysisSuggestions;

	private int designCriticalDefects;
	private int designMajorDefects;
	private int designMinorDefects;
	private int designSuggestions;

	private int codeReviewsCriticalDefects;
	private int codeReviewsMajorDefects;
	private int codeReviewsMinorDefects;
	private int codeReviewsSuggestions;
	
	private int unitTestingCriticalDefects;
	private int unitTestingMajorDefects;
	private int unitTestingMinorDefects;
	private int unitTestingSuggestions;
	
	private int integrationTestingCriticalDefects;
	private int integrationTestingMajorDefects;
	private int integrationTestingMinorDefects;
	private int integrationTestingSuggestions;

	private int systemTestingCriticalDefects;
	private int systemTestingMajorDefects;
	private int systemTestingMinorDefects;
	private int systemTestingSuggestions;
	
	private int productionCriticalDefects;
	private int productionMajorDefects;
	private int productionMinorDefects;
	private int productionSuggestions;
	
	private int totalDefects;
	private int totalWeightedDefects;
	private int defectDensity;
	private int reviewEffectivenessPercentage;
}
