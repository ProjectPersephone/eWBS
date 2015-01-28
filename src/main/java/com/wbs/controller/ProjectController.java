package com.wbs.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wbs.domain.Project;
import com.wbs.service.ProjectService;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findAllProject() {
		log.info("Requesting project list");
		List<Project> list = projectService.findAllProject();
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveProject(@RequestBody Project project) {
		log.info("Adding new project {}", project.getProjectName());
		projectService.saveProject(project);
		return new ResponseEntity<String>("Project added", HttpStatus.OK);
	}

	@RequestMapping(value = "/{projectName}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findProject(
			@PathVariable("projectName") String projectName) {
		log.info("Requesting project: {}", projectName);
		Project project = projectService.findProject(projectName);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseBody
	public ResponseEntity<?> duplicateKeyExceptionHandler(
			DuplicateKeyException e) {
		log.info("DublicateKeyExceptionHandler :");
		return new ResponseEntity<String>("Project Name already exists.",
				HttpStatus.CONFLICT);
	}
}
