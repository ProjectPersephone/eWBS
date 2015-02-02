package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.DefectLeakageMetric;
import com.wbs.repository.DefectLeakageMetricRepository;;

@Service
public class DefectLeakageMetricService {

		@Autowired
		private DefectLeakageMetricRepository defectLeakageMetricRepository;

		public void createCasualAnalysis(DefectLeakageMetric defectLeakageMetric) {
			defectLeakageMetricRepository.save(defectLeakageMetric);
		}
		
		public List<DefectLeakageMetric> findAllCasualAnalysis() {
			return defectLeakageMetricRepository.findAll();
		}
	
		public DefectLeakageMetric findProject(String projectName) {
			return defectLeakageMetricRepository.findProject(projectName);
		}
		
}
