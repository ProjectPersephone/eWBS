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

import com.wbs.domain.DefectPreventionPlan;
import com.wbs.service.DefectPreventionPlanService;;

@Controller
@RequestMapping(value="/defectPreventionPlan", method=RequestMethod.POST)
public class DefectPreventionPlanController {
	
	@Autowired
	private DefectPreventionPlanService  defectPreventionPlanService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<String> createDefectAndDPReviewBugsService(@RequestBody DefectPreventionPlan  defectPreventionPlan){
		defectPreventionPlanService.createDefectPreventionPlan(defectPreventionPlan);;
		return new ResponseEntity<String>("DefectPreventionPlan Table Created", HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAllDefectPreventionPlan", method=RequestMethod.POST)
	public ResponseEntity<List<DefectPreventionPlan>> findAllDefectAndDPReviewBugsService(){
		List<DefectPreventionPlan> Defetcts=defectPreventionPlanService.findAllDefectPreventionPlan();
		return new ResponseEntity<List<DefectPreventionPlan>>(Defetcts,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByProject", method=RequestMethod.GET)
	public ResponseEntity<DefectPreventionPlan> findByProject(@RequestParam(value="projectId", required=true) int projectId){
		DefectPreventionPlan Defetcts=defectPreventionPlanService.findByProject(projectId);
		return new ResponseEntity<DefectPreventionPlan>(Defetcts,HttpStatus.OK);
	}

}

