package com.wbs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.wbs.domain.StoryTask;

@Repository
public class StoryTaskRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveStoryTask(StoryTask storyTask) {
		System.out.println("MongoTemplate : " + mongoTemplate);
		mongoTemplate.save(storyTask);
	}

}
