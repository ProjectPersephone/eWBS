package com.wbs.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "DefectLeakageMetric")
public class DefectLeakageMetric extends AuditEntity {
	
	private String projectName;
	
	private List<Integer> requirements;
	private List<Integer> analysis;
	private List<Integer> design;
	private List<Integer> coding;
	private List<Integer> testing;
	private List<Integer> production;

	private String requirementsPreventiveAction;
	private String analysisPreventiveAction;
	private String designPreventiveAction;
	private String codingPreventiveAction;
	private String testingPreventiveAction;
	private String productionPreventiveAction;
}
