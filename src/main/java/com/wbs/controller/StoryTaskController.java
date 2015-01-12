package com.wbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wbs.service.StoryTaskService;

@Controller
public class StoryTaskController {

	@Autowired
	private StoryTaskService storyTaskService;

}
