package com.wbs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wbs.domain.TeamLeaves;
import com.wbs.service.TeamLeavesService;

@Controller
@RequestMapping(value="/teamLeaves", method=RequestMethod.POST)
public class TeamLeavesController {
	
	@Autowired
	private TeamLeavesService  teamLeavesService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findAllProject() {
		List<TeamLeaves> list = teamLeavesService.findAllTeamLeaves();
		return new ResponseEntity<List<TeamLeaves>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<String> createTeamLeaves(@RequestBody TeamLeaves  teamLeaves){
		teamLeavesService.createTeamLeaves(teamLeaves);
		return new ResponseEntity<String>("Casual Analysis Table Created", HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/findByProject", method = RequestMethod.GET)
	public ResponseEntity<?> findProject(@RequestParam(value = "projectName", required = true) String projectName) {
		TeamLeaves teamLeaves = teamLeavesService.findTeamLeaves(projectName);
		return teamLeaves != null ? new ResponseEntity<TeamLeaves>(teamLeaves, HttpStatus.OK)
				: new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);
	}
*/
}

