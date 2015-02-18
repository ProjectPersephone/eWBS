package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
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
		if (storyTask.getStoryTaskId() == 0) {
			storyTask.setStoryTaskId(counterRepository
					.getNextSequence("storyTasks"));
		}
		storyTaskRepository.saveStoryTask(storyTask);
	}

	public List<StoryTask> getStoryTaskList(String projectName) {
		return storyTaskRepository.getStoryTaskList(projectName);
	}

	public StoryTask getStoryTask(int storyTaskId) {
		return storyTaskRepository.getStoryTask(storyTaskId);
	}
	
	public List<DBObject> groupByStroyId(String projectName){
		return storyTaskRepository.groupByStroyId(projectName);
	}
	
	public List<DBObject> groupByPhase(String projectName){
		return storyTaskRepository.groupByPhase(projectName);
	}
	public List<DBObject> groupByResource(String projectName){
		return storyTaskRepository.groupByResource(projectName);
	}
}
