package com.wbs.domain;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "projects")
public class Project {

	private String projectName;
	private String description;
	private String preparedBy;
	private String approvedBy;
	private String fromDate;
	private String toDate;

}
