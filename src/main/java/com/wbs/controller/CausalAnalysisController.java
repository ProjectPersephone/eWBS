package com.wbs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wbs.domain.CausalAnalysis;
import com.wbs.service.CausalAnalysisService;

@Controller
@RequestMapping(value="/causalAnalysis", method=RequestMethod.POST)
public class CausalAnalysisController {
	
	@Autowired
	private CausalAnalysisService  causalAnalysisService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<String> createCauseService(@RequestParam(value="projectName", required=true) String projectName,@RequestBody CausalAnalysis  causalAnalysis){
		causalAnalysis.setProjectName(projectName);
		causalAnalysisService.createCasualAnalysis(causalAnalysis);
		return new ResponseEntity<String>("Casual Analysis Table Created", HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAllanalysis", method=RequestMethod.POST)
	public ResponseEntity<List<CausalAnalysis>> findAllCauseService(){
		List<CausalAnalysis> causalAnalysis=causalAnalysisService.findAllCasualAnalysis();
		return new ResponseEntity<List<CausalAnalysis>>(causalAnalysis,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByProject", method=RequestMethod.GET)
	public ResponseEntity<List<CausalAnalysis>> findByProject(@RequestParam(value="projectName", required=true) String projectName){
		List<CausalAnalysis> causalAnalysis=causalAnalysisService.findByProject(projectName);
		return new ResponseEntity<List<CausalAnalysis>>(causalAnalysis,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findCauseByName/{projectName}/{causeOfBug}",method=RequestMethod.GET)
	public ResponseEntity<CausalAnalysis> findCauseByName(@PathVariable(value="projectName") String projectName, @PathVariable(value="causeOfBug") String causeOfBug){
		CausalAnalysis causalAnalysis=causalAnalysisService.findByCauseName(projectName, causeOfBug);
		return new ResponseEntity<CausalAnalysis>(causalAnalysis,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/{projectName}", method=RequestMethod.POST)
	public ResponseEntity<String> causeUpdate(@PathVariable(value="projectName") String projectName,@RequestBody CausalAnalysis  causalAnalysis){
		causalAnalysis.setProjectName(projectName);
		causalAnalysisService.createCasualAnalysis(causalAnalysis);
		return new ResponseEntity<String>("Cause is updated", HttpStatus.OK);
	}
}

