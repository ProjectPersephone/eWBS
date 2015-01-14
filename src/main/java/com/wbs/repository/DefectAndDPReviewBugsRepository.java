package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.wbs.domain.DefectAndDPReviewBugs;
@Repository
public class DefectAndDPReviewBugsRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(DefectAndDPReviewBugs defectAndDPReviewBugs ) {
			System.out.println("DefectAndDPReviewBugs :" + defectAndDPReviewBugs);
			mongoTemplate.save(defectAndDPReviewBugs);
		}
		
		public List<DefectAndDPReviewBugs> findAll() {
			List<DefectAndDPReviewBugs> list=mongoTemplate.findAll(DefectAndDPReviewBugs.class);	
			return list;
		}
}
