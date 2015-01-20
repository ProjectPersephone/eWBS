package com.wbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import com.wbs.domain.StoryTask;

@Repository
public class StoryTaskRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveStoryTask(StoryTask storyTask) {
		mongoTemplate.save(storyTask);
	}

	public List<StoryTask> getStoryTaskList() {
		return mongoTemplate.findAll(StoryTask.class);
	}

	public StoryTask getStoryTask(int storyTaskId) {
		BasicQuery basicQuery = new BasicQuery("{'id':" + storyTaskId + "}");
		return mongoTemplate.findOne(basicQuery, StoryTask.class);
	}
}
