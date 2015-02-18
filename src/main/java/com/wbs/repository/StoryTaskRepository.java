package com.wbs.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.wbs.domain.StoryTask;

@Repository
public class StoryTaskRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveStoryTask(StoryTask storyTask) {
		mongoTemplate.save(storyTask);
	}

	public List<StoryTask> getStoryTaskList(String projectName) {
		Query query = new Query(Criteria.where("projectName").is(projectName));
		return mongoTemplate.find(query, StoryTask.class);
	}

	public StoryTask getStoryTask(int storyTaskId) {
		Query query = new Query(Criteria.where("id").is(storyTaskId));
		return mongoTemplate.findOne(query, StoryTask.class);
	}

	public List<DBObject> groupByStroyId(String projectName) {

		DBObject match = new BasicDBObject("$match", new BasicDBObject("projectName", projectName));

		DBObject groupFields = new BasicDBObject("_id", "$storyId");
		groupFields.put("effortPlanned", new BasicDBObject("$sum", "$effortPlanned"));
		groupFields.put("effortActual", new BasicDBObject("$sum", "$effortActual"));

		DBObject group = new BasicDBObject("$group", groupFields);

		DBObject sort = new BasicDBObject("$sort", new BasicDBObject("_id", 1));

		List<DBObject> pipeline = Arrays.asList(match, group, sort);
		AggregationOutput output = mongoTemplate.getCollection("storytask").aggregate(pipeline);
		List<DBObject> list = new ArrayList<DBObject>();
		for (DBObject result : output.results()) {
			list.add(result);
		}
		return list;
	}

	public List<DBObject> groupByPhase(String projectName) {

		DBObject match = new BasicDBObject("$match", new BasicDBObject("projectName", projectName));

		Map<String, Object> dbObjIdMap = new HashMap<String, Object>();
		dbObjIdMap.put("storyId", "$storyId");
		dbObjIdMap.put("phase", "$phase");
		DBObject groupFields = new BasicDBObject("_id", new BasicDBObject(dbObjIdMap));

		groupFields.put("effortPlanned", new BasicDBObject("$sum", "$effortPlanned"));
		groupFields.put("effortActual", new BasicDBObject("$sum", "$effortActual"));

		DBObject group = new BasicDBObject("$group", groupFields);

		DBObject sort = new BasicDBObject("$sort", new BasicDBObject("_id", 1));

		List<DBObject> pipeline = Arrays.asList(match, group, sort);
		AggregationOutput output = mongoTemplate.getCollection("storytask").aggregate(pipeline);
		List<DBObject> list = new ArrayList<DBObject>();
		for (DBObject result : output.results()) {
			list.add(result);
		}
		return list;
	}
	
	public List<DBObject> groupByResource(String projectName) {

		DBObject match = new BasicDBObject("$match", new BasicDBObject("projectName", projectName));
		Map<String, Object> dbObjIdMap = new HashMap<String, Object>();
		dbObjIdMap.put("storyId", "$storyId");
		dbObjIdMap.put("resource", "$resource");
		DBObject groupFields = new BasicDBObject("_id", new BasicDBObject(dbObjIdMap));

		groupFields.put("effortPlanned", new BasicDBObject("$sum", "$effortPlanned"));
		groupFields.put("effortActual", new BasicDBObject("$sum", "$effortActual"));

		DBObject group = new BasicDBObject("$group", groupFields);

		DBObject sort = new BasicDBObject("$sort", new BasicDBObject("_id", 1));

		List<DBObject> pipeline = Arrays.asList(match, group, sort);
		AggregationOutput output = mongoTemplate.getCollection("storytask").aggregate(pipeline);
		List<DBObject> list = new ArrayList<DBObject>();
		for (DBObject result : output.results()) {
			list.add(result);
		}
		return list;
	}
}
