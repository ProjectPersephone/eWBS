package com.wbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.TeamLeaves;
import com.wbs.repository.TeamLeavesRepository;

@Service
public class TeamLeavesService {

		@Autowired
		private TeamLeavesRepository teamLeavesRepository;

		public void createTeamLeaves(TeamLeaves teamLeaves) {
			teamLeavesRepository.save(teamLeaves);
		}
			
		/*public TeamLeaves findTeamLeaves(String projectName) {
			return teamLeavesRepository.findProject(projectName);
		}
		*/
		public List<TeamLeaves> findAllTeamLeaves() {
			return teamLeavesRepository.findAllTeamLeaves();
		}
		
}
