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

import com.wbs.domain.Story;
import com.wbs.service.StoryService;

@Slf4j
@RequestMapping(value = "/story")
@Controller
public class StoryController {

	@Autowired
	private StoryService storyService;

	@RequestMapping(value = "/list/{projectName}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findAllStory(
			@PathVariable("projectName") String projectName) {
		log.info("Requesting story list from project : {}", projectName);
		List<Story> list = storyService.findAllStory(projectName);
		return new ResponseEntity<List<Story>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveProject(@RequestBody Story story) {
		log.info("Adding new project {}", story.getStory());
		storyService.saveStory(story);
		return new ResponseEntity<String>("story added", HttpStatus.OK);
	}

	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findStory(@PathVariable("projectName") long _id) {
		log.info("Requesting project: {}", _id);
		Story story = storyService.findStory(_id);
		return new ResponseEntity<Story>(story, HttpStatus.OK);
	}
}
