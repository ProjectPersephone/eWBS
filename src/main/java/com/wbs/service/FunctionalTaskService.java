package com.wbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.FunctionalTask;
import com.wbs.repository.FunctionalTaskRepository;

@Service
public class FunctionalTaskService {

		@Autowired
		private FunctionalTaskRepository functionalTaskRepository;

		public void createFunctionalTask(FunctionalTask functionalTask) {
			functionalTaskRepository.save(functionalTask);
		}
	
		public FunctionalTask findProject(String projectName) {
			return functionalTaskRepository.findProject(projectName);
		}
		
}
