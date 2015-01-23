package com.wbs.domain;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "DefectLeakageMetric")
public class DefectLeakageMetric extends AuditEntity {
	
	private int projectId;

	private Map<String, Integer> requirements;
	private Map<String, Integer> analysis;
	private Map<String, Integer> design;
	private Map<String, Integer> coding;
	private Map<String, Integer> testing;
	private Map<String, Integer> production;

	private int requirementsLeakage;
	private int analysisLeakage;
	private int designLeakage;
	private int codeingLeakage;
	private int testingLeakage;
	private int productionLeakage;
	
	private String requirementsPreventiveaction;
	private String analysisPreventiveaction;
	private String designPreventiveaction;
	private String codeingPreventiveaction;
	private String testingPreventiveaction;
	private String productionPreventiveaction;
}
