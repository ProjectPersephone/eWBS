package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.wbs.domain.DefectPreventionPlan;
@Repository
public class DefectPreventionPlanRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(DefectPreventionPlan defectPreventionPlan ) {
			System.out.println("DefectPreventionPlan :" + defectPreventionPlan);
			mongoTemplate.save(defectPreventionPlan);
		}
		
		public List<DefectPreventionPlan> findAll() {
			List<DefectPreventionPlan> list=mongoTemplate.findAll(DefectPreventionPlan.class);	
			return list;
		}
}
