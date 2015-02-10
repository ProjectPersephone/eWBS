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

		public void save(CausalAnalysis causalAnalysis) {
			System.out.println("CausalAnalysis :" + causalAnalysis);
			mongoTemplate.save(causalAnalysis);
		}
		
		public List<CausalAnalysis> findAll() {
			List<CausalAnalysis> list=mongoTemplate.findAll(CausalAnalysis.class);	
			return list;
		}
		
		public List<CausalAnalysis> findByProject(String projectName) {
			Query query = new Query(Criteria.where("projectName").is(projectName));
			List<CausalAnalysis> causalAnalysis = mongoTemplate.find(query, CausalAnalysis.class);
			return causalAnalysis;
		}

		public CausalAnalysis findByCauseofBug(String projectName,String causeOfBug)
		{
			Query query=new Query(Criteria.where("projectName").is(projectName).and("causeOfBug").is(causeOfBug));
			CausalAnalysis causalAnalysis = mongoTemplate.findOne(query, CausalAnalysis.class);
			return causalAnalysis;
		}
		
		public void updateCause(CausalAnalysis causalAnalysis)
		{
			mongoTemplate.save(causalAnalysis);
			/*Query query=new Query(Criteria.where("projectName").is(projectName));
			System.out.println(query);
			CausalAnalysis causalAnalysis = mongoTemplate.u(query, CausalAnalysis.class);
			System.out.println(causalAnalysis);
			return causalAnalysis;*/
		}
}
