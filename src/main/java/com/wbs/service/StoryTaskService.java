package com.wbs.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wbs.domain.StoryTask;
import com.wbs.repository.StoryTaskRepository;

public class StoryTaskService {

	@Autowired
	private StoryTaskRepository storyTaskRepository;

	public void saveStoryTask(StoryTask storyTask) {

	}

}
