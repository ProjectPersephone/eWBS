package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.Project;
import com.wbs.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public void saveProject(Project project){
		projectRepository.saveProject(project);
	}
	
	public void updateProject(Project project){
		projectRepository.updateProject(project);
	}

	public Project findProject(String projectName) {
		return projectRepository.findProject(projectName);
	}

	public List<Project> findAllProject() {
		return projectRepository.findAllProject();
	}

}
