package com.wbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wbs.domain.DefectAndDPReviewBugs;
import com.wbs.service.DefectAndDPReviewBugsService;

@Controller
@RequestMapping(value = "/defect", method = RequestMethod.POST)
public class DefectAndDPReviewBugsController {

	@Autowired
	private DefectAndDPReviewBugsService defectAndDPReviewBugsService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> createDefectAndDPReviewBugsService(
			@RequestBody DefectAndDPReviewBugs defectAndDPReviewBugs) {
		defectAndDPReviewBugsService.createDefectAndDPReviewBugs(defectAndDPReviewBugs);
		return new ResponseEntity<String>("DefectAndDPReviewBugs Table Created", HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value="/findAll", method=RequestMethod.POST) public
	 * ResponseEntity<List<DefectAndDPReviewBugs>>
	 * findAllDefectAndDPReviewBugsService(){ List<DefectAndDPReviewBugs>
	 * Defetcts=defectAndDPReviewBugsService.findAllDefectAndDPReviewBugs();
	 * return new
	 * ResponseEntity<List<DefectAndDPReviewBugs>>(Defetcts,HttpStatus.OK); }
	 */

	@RequestMapping(value = "/findByProject", method = RequestMethod.GET)
	public ResponseEntity<?> findByProject(@RequestParam(value = "projectName", required = true) String projectName) {
		DefectAndDPReviewBugs defectAndDPReviewBugs = defectAndDPReviewBugsService
				.findAllDefectAndDPReviewBugs(projectName);
		return defectAndDPReviewBugs != null ? new ResponseEntity<DefectAndDPReviewBugs>(defectAndDPReviewBugs,
				HttpStatus.OK) : new ResponseEntity<String>("Record not found.", HttpStatus.NOT_FOUND);
	}
}
