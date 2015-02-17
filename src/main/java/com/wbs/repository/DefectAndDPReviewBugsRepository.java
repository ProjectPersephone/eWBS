package com.wbs.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.wbs.domain.DefectAndDPReviewBugs;
@Repository
public class DefectAndDPReviewBugsRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(DefectAndDPReviewBugs defectAndDPReviewBugs ) {
			System.out.println("DefectAndDPReviewBugs :" + defectAndDPReviewBugs);
			mongoTemplate.save(defectAndDPReviewBugs);
		}
		
		public DefectAndDPReviewBugs findAll(String projectName) {
			Query query = new Query(Criteria.where("projectName").is(projectName));
			DefectAndDPReviewBugs list=mongoTemplate.findOne(query, DefectAndDPReviewBugs.class);	
			return list;
		}
		
		public DefectAndDPReviewBugs findByProject(int projectId) {
			Query query = new Query(Criteria.where("projectId").is(projectId));
			System.out.println(query);
			DefectAndDPReviewBugs defectAndDPreviewBugs = mongoTemplate.findOne(query, DefectAndDPReviewBugs.class);
			System.out.println(defectAndDPreviewBugs);
			return defectAndDPreviewBugs;
		}
}
