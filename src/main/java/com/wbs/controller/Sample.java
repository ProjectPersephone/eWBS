package com.wbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wbs.domain.StoryTask;

@Controller
@RequestMapping("/sample")
public class Sample {

	@RequestMapping("/{msg}")
	@ResponseBody
	public String check(@PathVariable("msg") String msg) {
		System.out.println("Hello");
		StoryTask storyTask = new StoryTask();
		storyTask.setName("sham");
		
		return "Welcome : " + msg;
	}
}
