package com.wbs.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.wbs.domain.FunctionalTask;

@Repository
public class FunctionalTaskRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(FunctionalTask functionalTask ) {
			mongoTemplate.save(functionalTask);
		}
		
		public FunctionalTask findProject(String projectName) {
			Query query = new Query(Criteria.where("projectName").is(projectName));
			return mongoTemplate.findOne(query, FunctionalTask.class);
		}

}
