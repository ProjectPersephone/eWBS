package com.wbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wbs.domain.Story;

@Repository
public class StoryRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Story> findAllStory(String projectName) {
		Query query = new Query(Criteria.where("projectName").is(projectName));
		return mongoTemplate.find(query, Story.class);
	}

	public void saveStory(Story story) {
		mongoTemplate.save(story);
	}

	public Story findStory(long _id) {
		Query query = new Query(Criteria.where("_id").is(_id));
		return mongoTemplate.findOne(query, Story.class);
	}

	public void deleteStory(long _id) {
		mongoTemplate.remove(_id);
	}
}
