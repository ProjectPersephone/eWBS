package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.DefectPreventionPlan;
import com.wbs.repository.DefectPreventionPlanRepository;

@Service
public class DefectPreventionPlanService {

		@Autowired
		private DefectPreventionPlanRepository defectPreventionPlanRepository;

		public void createDefectPreventionPlan(DefectPreventionPlan defectPreventionPlan) {
			defectPreventionPlanRepository.save(defectPreventionPlan);
		}
		
		public List<DefectPreventionPlan> findAllDefectPreventionPlan() {
			return defectPreventionPlanRepository.findAll();
		}
		
		public DefectPreventionPlan findByProject(int projectId) {
			return defectPreventionPlanRepository.findByProject(projectId);
		}
				
}
