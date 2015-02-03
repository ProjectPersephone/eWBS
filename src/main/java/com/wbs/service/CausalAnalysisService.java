package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.CausalAnalysis;
import com.wbs.repository.CausalAnalysisRepository;

@Service
public class CausalAnalysisService {

		@Autowired
		private CausalAnalysisRepository causalAnalysisRepository;

		public void createCasualAnalysis(CausalAnalysis causalAnalysis) {
			causalAnalysisRepository.save(causalAnalysis);
		}
		
		public List<CausalAnalysis> findAllCasualAnalysis() {
			return causalAnalysisRepository.findAll();
		}
		
		public List<CausalAnalysis> findByProject(String projectName) {
			return causalAnalysisRepository.findByProject(projectName);
		}

		public CausalAnalysis findByCauseName(String projectName,String causeOfBug){
			return causalAnalysisRepository.findByCauseofBug(projectName, causeOfBug);
		}
		
		public void updateCause(CausalAnalysis causalAnalysis){
			causalAnalysisRepository.updateCause(causalAnalysis);
		}
}
