package com.wbs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	public ResponseEntity<String> createDefectAndDPReviewBugsService(@RequestBody CausalAnalysis  causalAnalysis){
		causalAnalysisService.createCasualAnalysis(causalAnalysis);
		return new ResponseEntity<String>("Casual Analysis Table Created", HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAllanalysis", method=RequestMethod.POST)
	public ResponseEntity<List<CausalAnalysis>> findAllDefectAndDPReviewBugsService(){
		List<CausalAnalysis> Defetcts=causalAnalysisService.findAllCasualAnalysis();
		return new ResponseEntity<List<CausalAnalysis>>(Defetcts,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByProject", method=RequestMethod.GET)
	public ResponseEntity<CausalAnalysis> findByProject(@RequestParam(value="projectId", required=true) int projectId){
		CausalAnalysis Defetcts=causalAnalysisService.findByProject(projectId);
		return new ResponseEntity<CausalAnalysis>(Defetcts,HttpStatus.OK);
	}

}

