package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
}
