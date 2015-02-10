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

import com.wbs.domain.DefectPreventionPlan;
import com.wbs.service.DefectPreventionPlanService;;

@Controller
@RequestMapping(value="/defectPreventionPlan", method=RequestMethod.POST)
public class DefectPreventionPlanController {
	
	@Autowired
	private DefectPreventionPlanService  defectPreventionPlanService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<String> createDefectAndDPReviewBugsService(@RequestParam(value="projectName", required=true) String projectName,@RequestBody DefectPreventionPlan  defectPreventionPlan){
		defectPreventionPlan.setProjectName(projectName);
		defectPreventionPlanService.createDefectPreventionPlan(defectPreventionPlan);
		return new ResponseEntity<String>("DefectPreventionPlan Table Created", HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAllDefectPreventionPlan", method=RequestMethod.POST)
	public ResponseEntity<List<DefectPreventionPlan>> findAllDefectAndDPReviewBugsService(){
		List<DefectPreventionPlan> Defetcts=defectPreventionPlanService.findAllDefectPreventionPlan();
		return new ResponseEntity<List<DefectPreventionPlan>>(Defetcts,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByProject", method=RequestMethod.GET)
	public ResponseEntity<List<DefectPreventionPlan>> findByProject(@RequestParam(value="projectName", required=true) String projectName){
		List<DefectPreventionPlan> Defetcts=defectPreventionPlanService.findByProject(projectName);
		return new ResponseEntity<List<DefectPreventionPlan>>(Defetcts,HttpStatus.OK);
	}
	@RequestMapping(value="/findDefectByName/{projectName}/{defectTypeAndDetails}",method=RequestMethod.GET)
	public ResponseEntity<DefectPreventionPlan> findDefectByName(@PathVariable(value="projectName") String projectName, @PathVariable(value="defectTypeAndDetails") String defectTypeAndDetails){
		DefectPreventionPlan Defetcts=defectPreventionPlanService.findByDefectName(projectName, defectTypeAndDetails);
		return new ResponseEntity<DefectPreventionPlan>(Defetcts,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/{projectName}", method=RequestMethod.POST)
	public ResponseEntity<String> defectUpdate(@PathVariable(value="projectName") String projectName,@RequestBody DefectPreventionPlan  defectPreventionPlan){
		defectPreventionPlan.setProjectName(projectName);
		defectPreventionPlanService.createDefectPreventionPlan(defectPreventionPlan);
		return new ResponseEntity<String>("defect is updated", HttpStatus.OK);
	}
}

