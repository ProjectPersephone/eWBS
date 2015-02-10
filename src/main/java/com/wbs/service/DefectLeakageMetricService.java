package com.wbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.DefectLeakageMetric;
import com.wbs.repository.DefectLeakageMetricRepository;;

@Service
public class DefectLeakageMetricService {

		@Autowired
		private DefectLeakageMetricRepository defectLeakageMetricRepository;

		public void createDefectLeakageMetric(DefectLeakageMetric defectLeakageMetric) {
			System.out.println(defectLeakageMetric.getProjectName());
			defectLeakageMetricRepository.save(defectLeakageMetric);
		}
		
		public DefectLeakageMetric findProject(String projectName) {
			return defectLeakageMetricRepository.findProject(projectName);
		}
		
}
