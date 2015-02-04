package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.wbs.domain.CausalAnalysis;
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
		
		public List<DefectPreventionPlan> findByProject(String projectName) {
			Query query = new Query(Criteria.where("projectName").is(projectName));
			System.out.println(query);
			List<DefectPreventionPlan> defectPreventionPlan = mongoTemplate.find(query, DefectPreventionPlan.class);
			System.out.println(defectPreventionPlan);
			return defectPreventionPlan;
		}

		public DefectPreventionPlan findBydefectTypeAndDetails(String projectName, String defectTypeAndDetails) {
			Query query=new Query(Criteria.where("projectName").is(projectName).and("defectTypeAndDetails").is(defectTypeAndDetails));
			System.out.println(query);
			DefectPreventionPlan defectPreventionPlan = mongoTemplate.findOne(query, DefectPreventionPlan.class);
			System.out.println(defectPreventionPlan);
			return defectPreventionPlan;
		}

		public void updateDefect(DefectPreventionPlan defectPreventionPlan) {
			mongoTemplate.save(defectPreventionPlan);
			
		}

}
