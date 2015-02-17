package com.wbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.DefectAndDPReviewBugs;
import com.wbs.repository.DefectAndDPReviewBugsRepository;;

@Service
public class DefectAndDPReviewBugsService {

		@Autowired
		private DefectAndDPReviewBugsRepository defectAndDPReviewBugsRepository;

		public void createDefectAndDPReviewBugs(DefectAndDPReviewBugs defectAndDPReviewBugs) {
			defectAndDPReviewBugsRepository.save(defectAndDPReviewBugs);
		}
		
		public DefectAndDPReviewBugs findAllDefectAndDPReviewBugs(String projectName) {
			return defectAndDPReviewBugsRepository.findAll(projectName);
		}
		
		public DefectAndDPReviewBugs findByProject(int projectId) {
			return defectAndDPReviewBugsRepository.findByProject(projectId);
		}

}
