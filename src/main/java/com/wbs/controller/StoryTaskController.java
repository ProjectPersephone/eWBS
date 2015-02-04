package com.wbs.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wbs.domain.StoryTask;
import com.wbs.service.StoryTaskService;

@Controller
@Slf4j
@RequestMapping("/storytask")
public class StoryTaskController {

	@Autowired
	private StoryTaskService storyTaskService;

	@RequestMapping(value = "/list/{projectName}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getStoryTaskList(
			@PathVariable("projectName") String projectName) {
		log.info("Getting story task list");
		List<StoryTask> storyTaskList = storyTaskService
				.getStoryTaskList(projectName);
		return ((null == storyTaskList) || (storyTaskList.isEmpty())) ? new ResponseEntity<String>(
				"StoryTask not found ", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<StoryTask>>(storyTaskList,
						HttpStatus.OK);
	}

	@RequestMapping(value = "/{storyTaskId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> getStoryTask(
			@PathVariable("storyTaskId") int storyTaskId) {
		log.info("Getting story task :{}" + storyTaskId);
		return new ResponseEntity<StoryTask>(
				storyTaskService.getStoryTask(storyTaskId), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveStoryTask(@RequestBody StoryTask storyTask) {
		log.info("Adding new storyTask {}", storyTask.getTask());
		storyTaskService.saveStoryTask(storyTask);
		return new ResponseEntity<String>("story added", HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateStoryTask(@RequestBody() StoryTask storyTask) {
		log.info("Updatting  story task :{}" + storyTask.getTask());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
