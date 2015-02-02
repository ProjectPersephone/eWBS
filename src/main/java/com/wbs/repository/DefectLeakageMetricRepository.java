package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.wbs.domain.DefectLeakageMetric;

@Repository
public class DefectLeakageMetricRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(DefectLeakageMetric defectLeakageMetric ) {
			System.out.println("DefectLeakageMetric :" + defectLeakageMetric);
			mongoTemplate.save(defectLeakageMetric);
		}
		
		public List<DefectLeakageMetric> findAll() {
			List<DefectLeakageMetric> list=mongoTemplate.findAll(DefectLeakageMetric.class);	
			return list;
		}
		
		public DefectLeakageMetric findProject(String projectName) {
			Query query = new Query(Criteria.where("projectName").is(projectName));
			return mongoTemplate.findOne(query, DefectLeakageMetric.class);
		}

}
