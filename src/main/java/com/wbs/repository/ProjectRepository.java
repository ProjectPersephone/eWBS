package com.wbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wbs.domain.Project;

@Repository
public class ProjectRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveProject(Project project) {
		mongoTemplate.insert(project);
	}

	public void updateProject(Project project) {
		mongoTemplate.save(project);
	}

	public Project findProject(String projectName) {
		Query query = new Query(Criteria.where("projectName").is(projectName));
		return mongoTemplate.findOne(query, Project.class);
	}

	public List<Project> findAllProject() {
		return mongoTemplate.findAll(Project.class);
	}
}
