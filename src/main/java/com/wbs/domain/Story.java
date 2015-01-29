package com.wbs.domain;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "stories")
public class Story {

	private long _id;
	private String story;
	private String type;
	private String projectName;

}
