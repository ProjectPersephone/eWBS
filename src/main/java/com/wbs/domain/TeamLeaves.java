package com.wbs.domain;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "TeamLeaves")
public class TeamLeaves {

	private String employeeId;
	private String name;
	private String startDate;
	private String endDate;

}
