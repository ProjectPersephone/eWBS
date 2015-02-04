package com.wbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wbs.domain.StoryTask;

@Repository
public class StoryTaskRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveStoryTask(StoryTask storyTask) {
		mongoTemplate.insert(storyTask);
	}

	public List<StoryTask> getStoryTaskList(String projectName) {
		Query query = new Query(Criteria.where("projectName").is(projectName));
		return mongoTemplate.find(query, StoryTask.class);
	}

	public StoryTask getStoryTask(int storyTaskId) {
		Query query = new Query(Criteria.where("id").is(storyTaskId));
		return mongoTemplate.findOne(query, StoryTask.class);
	}
}
