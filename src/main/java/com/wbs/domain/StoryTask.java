package com.wbs.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "storytask")
public class StoryTask {

	private String name;
}
