package com.wbs.service;

import java.util.List;

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

	public List<StoryTask> getStoryTaskList() {
		return storyTaskRepository.getStoryTaskList();
	}

	public StoryTask getStoryTask(int storyTaskId) {
		return storyTaskRepository.getStoryTask(storyTaskId);
	}
}
