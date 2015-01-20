package com.wbs.service;

import java.util.List;

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
		
		public List<DefectAndDPReviewBugs> findAllDefectAndDPReviewBugs() {
			return defectAndDPReviewBugsRepository.findAll();
		}
		
		public DefectAndDPReviewBugs findByProject(int projectId) {
			return defectAndDPReviewBugsRepository.findByProject(projectId);
		}

}
