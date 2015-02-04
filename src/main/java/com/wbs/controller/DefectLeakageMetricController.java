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
import com.wbs.domain.DefectLeakageMetric;
import com.wbs.service.DefectLeakageMetricService;

@Controller
@RequestMapping(value = "/DefectLeakageMetric", method = RequestMethod.POST)
public class DefectLeakageMetricController {

	@Autowired
	private DefectLeakageMetricService defectLeakageMetricService;

	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public ResponseEntity<String> createDefectAndDPReviewBugsService(
			@RequestParam(value = "projectName", required = true) String projectName,
			@RequestBody DefectLeakageMetric defectLeakageMetric) {
		System.out.println("controller" + projectName);
		defectLeakageMetric.setProjectName(projectName);
		defectLeakageMetricService.createCasualAnalysis(defectLeakageMetric);
		return new ResponseEntity<String>("DefectLeakageMetric Table Created", HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<DefectLeakageMetric>> findAllDefectAndDPReviewBugsService() {
		List<DefectLeakageMetric> Defetcts = defectLeakageMetricService.findAllCasualAnalysis();
		return new ResponseEntity<List<DefectLeakageMetric>>(Defetcts, HttpStatus.OK);
	}

	@RequestMapping(value = "/findByProject", method = RequestMethod.GET)
	public ResponseEntity<?> findProject(@RequestParam(value = "projectName", required = true) String projectName) {
		DefectLeakageMetric defectLeakageMetric = defectLeakageMetricService.findProject(projectName);
		return defectLeakageMetric != null ? new ResponseEntity<DefectLeakageMetric>(defectLeakageMetric, HttpStatus.OK)
				: new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);
	}
}
