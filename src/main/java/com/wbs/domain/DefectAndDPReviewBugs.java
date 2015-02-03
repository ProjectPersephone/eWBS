package com.wbs.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "DefectAndDPReviewBugs")
public class DefectAndDPReviewBugs extends AuditEntity {
	
	private List<Integer> requirementsDefects;
	private List<Integer> analysisDefects;
	private List<Integer> designDefects;
	private List<Integer> codeReviewsDefects;
	private List<Integer> unitTestingDefects;
	private List<Integer> integrationTestingDefects;
	private List<Integer> systemTestingDefects;
	private List<Integer> productionDefects;
	private String projectName;

}
