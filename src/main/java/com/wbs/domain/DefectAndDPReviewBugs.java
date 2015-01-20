package com.wbs.domain;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "DefectAndDPReviewBugs")
public class DefectAndDPReviewBugs extends AuditEntity {
	
	private int projectId;

	private Map<String, Integer> requirementsDefects;
	private Map<String, Integer> analysisDefects;
	private Map<String, Integer> designDefects;
	private Map<String, Integer> codeReviewsDefects;
	private Map<String, Integer> unitTestingDefects;
	private Map<String, Integer> integrationTestingDefects;
	private Map<String, Integer> systemTestingDefects;
	private Map<String, Integer> productionDefects;

	
	private int totalDefects;
	private int totalWeightedDefects;
	private int defectDensity;
	private int reviewEffectivenessPercentage;
}
