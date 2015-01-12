package com.wbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.StoryTask;
import com.wbs.repository.StoryTaskRepository;

@Service
public class StoryTaskService {

	@Autowired
	private StoryTaskRepository storyTaskRepository;

	public void saveStoryTask(StoryTask storyTask) {
		storyTaskRepository.saveStoryTask(storyTask);
	}
}
