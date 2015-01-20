package com.wbs.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "storytask")
public class StoryTask {

	private String tasks;
	private long storyId;
	private String phase; // It will come from list of phases.
	private String status;
	private int workCompletedPer;
	private String resource;
	private String plannedStartDate; // Format (mm/dd/yyyy)
	private String plannedEndDate; // Format (mm/dd/yyyy)
	private String actualStartDate; // Format (mm/dd/yyyy)
	private String actualEndDate; // Format (mm/dd/yyyy)
	private int effortPlanned;
	private int effortActual;
	private float effortVariance; // formula
	private float scheduleVariance; // formula
	private String remarks;
	private String blocker; // It will come from list of blockers
	private String spring;
	private int duration;
	private String iterationStart;
	private String iterationEnd;

}
