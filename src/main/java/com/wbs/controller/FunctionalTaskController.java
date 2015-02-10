package com.wbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.wbs.domain.FunctionalTask;
import com.wbs.service.FunctionalTaskService;

@Controller
@RequestMapping(value = "/FunctionalTask")
public class FunctionalTaskController {

	@Autowired
	private FunctionalTaskService functionalTaskService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> createFunctionalTask(
			@RequestParam(value = "projectName", required = true) String projectName,
			@RequestBody FunctionalTask functionalTask) {
		functionalTask.setProjectName(projectName);
		functionalTaskService.createFunctionalTask(functionalTask);
		return new ResponseEntity<String>("FunctionalTask Table Created", HttpStatus.OK);
	}

	@RequestMapping(value = "/findByProject", method = RequestMethod.GET)
	public ResponseEntity<?> findProject(@RequestParam(value = "projectName", required = true) String projectName) {
		FunctionalTask functionalTask = functionalTaskService.findProject(projectName);
		return functionalTask != null ? new ResponseEntity<FunctionalTask>(functionalTask, HttpStatus.OK)
				: new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);
	}
}
