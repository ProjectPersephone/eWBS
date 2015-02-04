package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.StoryTask;
import com.wbs.repository.CounterRepository;
import com.wbs.repository.StoryTaskRepository;

@Service
public class StoryTaskService {

	@Autowired
	private StoryTaskRepository storyTaskRepository;
	@Autowired
	private CounterRepository counterRepository;

	public void saveStoryTask(StoryTask storyTask) {
		storyTask.setStoryTaskId(counterRepository
				.getNextSequence("storyTasks"));
		storyTaskRepository.saveStoryTask(storyTask);
	}

	public List<StoryTask> getStoryTaskList(String projectName) {
		return storyTaskRepository.getStoryTaskList(projectName);
	}

	public StoryTask getStoryTask(int storyTaskId) {
		return storyTaskRepository.getStoryTask(storyTaskId);
	}
}
