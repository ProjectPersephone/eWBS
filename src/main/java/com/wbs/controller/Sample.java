package com.wbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wbs.domain.StoryTask;
import com.wbs.service.StoryTaskService;

@Controller
@RequestMapping("/samplea")
public class Sample {

	@Autowired
	private StoryTaskService storyTaskService;

	@RequestMapping("/{msg}")
	@ResponseBody
	public String check(@PathVariable("msg") String msg) {
		System.out.println("Hello");
		StoryTask storyTask = new StoryTask();
		storyTask.setName("sham");
		System.out.println("Story : "+storyTaskService);
		storyTaskService.saveStoryTask(storyTask);
		System.out.println("Story task saved");
		return "Welcome : " + msg;
	}
}
