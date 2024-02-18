package com.eqa.eqastudyplanservice.controller;

import com.eqa.eqastudyplanservice.constant.CommonConstants;
import com.eqa.eqastudyplanservice.exception.CustomException;
import com.eqa.eqastudyplanservice.model.ResponseObject;
import com.eqa.eqastudyplanservice.model.StudyPlan;
import com.eqa.eqastudyplanservice.service.StudyPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CommonConstants.API_BASE_PATH + CommonConstants.API_SURVEY_PATH)
@Validated
@Slf4j
public class StudyPlanController {

	@Autowired
	private StudyPlanService studyPlanService;

	@PostMapping
	public ResponseEntity<ResponseObject> saveStudyPlan(@RequestHeader("username") String username, @Validated @RequestBody StudyPlan studyPlan) throws CustomException {
		log.info("saveStudyPlan() : Start");
		log.info("StudyPlan data {}", studyPlan);
		return studyPlanService.saveStudyPlan(studyPlan, username);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> updateStudyPlan(@RequestHeader("username") String username,@Validated @RequestBody StudyPlan studyPlan,
													 @PathVariable("id") long id) throws CustomException {
		log.info("updateStudyPlan() : Start");
		log.info("StudyPlan id {} and Data {}", id, studyPlan);
		return studyPlanService.updateSurvey(survey, id, username);
	}
	@DeleteMapping
	public ResponseEntity<ResponseObject> deleteSurvey(@RequestParam List<Long> ids)
			throws CustomException {
		log.info("deleteSurvey() : Start, ids are {}", ids);
		return surveyService.deleteSurvey(ids);
	}

	@GetMapping("{id}")
	public ResponseEntity<ResponseObject> getSurveyById(@PathVariable Long id) throws CustomException{
		log.info("getSurveyById() : Start, id is {}", id);
		return surveyService.getSurveyById(id);
	}
	@GetMapping("/loggedInByUser")
	public ResponseEntity<ResponseObject> getCreatedByAndSemesterAndYear(@RequestHeader("username") String username,
															  @RequestParam String semester,
															  @RequestParam Integer year) throws CustomException {
		log.info("getSurveyByUserName() : Start, username {}, semester {}, year {}", username, semester, year);
		return surveyService.getCreatedByAndSemesterAndYear(username, semester, year);
	}
	@GetMapping("/forCafReport")
	public ResponseEntity<ResponseObject> getSurveyLinkDetailsForCafReport(
			@RequestHeader("username") String username,
			@RequestParam String courseCode,@RequestParam Integer sectionNumber,
			@RequestParam String collegeId,@RequestParam  String campusId,
			@RequestParam String departmentId,@RequestParam  String semester,@RequestParam  Integer year) throws CustomException {
		log.info("getSurveyLinkDetailsForCafReport() : Start, username {}, courseCode {}, " +
				"sectionNumber {},collegeId {}, campusId {},departmentId {}, semester {} and year {}", username,courseCode, sectionNumber,collegeId, campusId,departmentId, semester, year);
		return surveyService.getSurveyLinkDetailsForCafReport(username,courseCode, sectionNumber,collegeId, campusId,departmentId, semester, year);
	}
	@GetMapping
	public ResponseEntity<ResponseObject> getAllSurvey(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) throws CustomException {
		log.info("getAllSurvey() : Start, pageNo {}, pageSize {}, sortBy {}", pageNo,pageSize, sortBy );
		return surveyService.getAllSurvey(pageNo, pageSize, sortBy);
	}
	@GetMapping("/search")
	public ResponseEntity<ResponseObject> searchSurvey(@RequestParam String courseCode,
													   @RequestParam Integer sectionNumber,
													   @RequestParam String semester,
													   @RequestParam Integer year
													   ) throws CustomException {
		log.info("searchSurveyByCourseCode() : Start, Course Code {},sectionNumber {}, " +
				"semester {}, year {}", courseCode, sectionNumber, semester, year);
		return surveyService.searchSurvey(courseCode, sectionNumber, semester, year);
	}
}
