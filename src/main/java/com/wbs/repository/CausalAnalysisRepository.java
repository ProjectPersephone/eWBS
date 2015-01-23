package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import com.wbs.domain.CausalAnalysis;
@Repository
public class CausalAnalysisRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(CausalAnalysis causalAnalysis ) {
			System.out.println("CausalAnalysis :" + causalAnalysis);
			mongoTemplate.save(causalAnalysis);
		}
		
		public List<CausalAnalysis> findAll() {
			List<CausalAnalysis> list=mongoTemplate.findAll(CausalAnalysis.class);	
			return list;
		}
		
		public CausalAnalysis findByProject(int projectId) {
			Query query = new Query(Criteria.where("projectId").is(projectId));
			System.out.println(query);
			CausalAnalysis causalAnalysis = mongoTemplate.findOne(query, CausalAnalysis.class);
			System.out.println(causalAnalysis);
			return causalAnalysis;
		}

}
