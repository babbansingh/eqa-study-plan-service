package com.eqa.eqastudyplanservice.service;

import com.eqa.eqastudyplanservice.constant.StudyPlanResponseConstant;
import com.eqa.eqastudyplanservice.exception.CustomException;
import com.eqa.eqastudyplanservice.model.ResponseObject;
import com.eqa.eqastudyplanservice.model.StudyPlan;
import com.eqa.eqastudyplanservice.repo.StudyPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.eqa.eqastudyplanservice.util.CommonUtils.buildSuccessResponse;

@Service
@Slf4j
public class StudyPlanService {

	@Autowired
	private StudyPlanRepository studyPlanRepository;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseObject> saveStudyPlan(StudyPlan studyPlan, String username) throws CustomException {
		try {
			studyPlan.setCreatedBy(username);
			studyPlan.setUpdatedBy(username);
			StudyPlan savedStudyPlan = studyPlanRepository.save(studyPlan);
			log.info("Study plan saved successfully");

			return buildSuccessResponse(StudyPlanResponseConstant.STUDYPLAN_CREATE_SUCCESS, savedStudyPlan);
		} catch (Exception ex) {
			log.error("Error while saving Study plan {}", ex.getMessage());
			throw new CustomException(StudyPlanResponseConstant.STUDYPLAN_CREATION_FAILED);
		}
	}

	public ResponseEntity<ResponseObject> getAllStudyPlan(Integer pageNo, Integer pageSize, String sortBy) throws CustomException {
		try {
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<StudyPlan> pagedResult = studyPlanRepository.findAll(paging);
			log.info("StudyPlan fetched successfully from DB");
			return buildSuccessResponse(StudyPlanResponseConstant.STUDYPLAN_DATA_LIST_SUCCESS, pagedResult.getContent());
		} catch (Exception ex) {
			log.error("Error while fetching StudyPlan list {}", ex.getMessage());
			throw new CustomException(StudyPlanResponseConstant.STUDYPLAN_DATA_LIST_FAILED);
		}
	}

	public ResponseEntity<ResponseObject> updateStudyPlan(StudyPlan studyPlan, long id, String username) throws CustomException {
		StudyPlan existingStudyPlan = getExistingStudyPlan(id);
		try {
			modelMapper.map(studyPlan, existingStudyPlan);
			existingStudyPlan.setUpdatedBy(username);
			StudyPlan updatedSurvey = studyPlanRepository.save(existingStudyPlan);
			log.info("StudyPlan updated successfully");
			return buildSuccessResponse(StudyPlanResponseConstant.STUDYPLAN_UPDATE_SUCCESS, updatedSurvey);
		} catch (Exception ex) {
			log.error("Error while updating StudyPlan {}", ex.getMessage());
			throw new CustomException(StudyPlanResponseConstant.STUDYPLAN_UPDATE_FAILED);
		}
	}

	public ResponseEntity<ResponseObject> getStudyPlanById(Long id) throws CustomException {
		StudyPlan existingStudyPlan = getExistingStudyPlan(id);
		try {
			return buildSuccessResponse(StudyPlanResponseConstant.STUDYPLAN_GET_SUCCESS, existingStudyPlan);
		} catch (Exception ex) {
			log.error("Error while fetching StudyPlan {}", ex.getMessage());
			throw new CustomException(StudyPlanResponseConstant.STUDYPLAN_NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseObject> deleteSurvey(List<Long> ids) throws CustomException {
		try {
			surveyRepository.softDelete(ids);
			log.info("Survey deleted with ids {}", ids);
			return buildSuccessResponse(com.eqa.eqasurveyservice.constant.StudyPlanResponseConstant.SURVEY_DELETE_SUCCESS, null);
		} catch (Exception ex) {
			log.error("Error while deleting Survey {}", ex.getMessage());
			throw new CustomException(com.eqa.eqasurveyservice.constant.StudyPlanResponseConstant.SURVEY_DELETION_FAILED);
		}
	}

	public ResponseEntity<ResponseObject> searchSurvey(String courseCode,Integer sectionNumber,
																  String semester, Integer year) throws CustomException {
		try {
			List<Survey> surveys = surveyRepository.findAllByCourseCodeAndSectionNumberAndSemesterAndYear(courseCode, sectionNumber, semester, year);
			log.info("{} Surveys fetched successfully from DB", surveys.size());
			return buildSuccessResponse(com.eqa.eqasurveyservice.constant.StudyPlanResponseConstant.SURVEY_SEARCH_SUCCESS, surveys);
		} catch (Exception ex) {
			log.error("Error while searching Survey {}", ex.getMessage());
			throw new CustomException(com.eqa.eqasurveyservice.constant.StudyPlanResponseConstant.SURVEY_SEARCH_FAILED);
		}
	}

	private StudyPlan getExistingStudyPlan(Long id) {
		return studyPlanRepository.findById(id)
				.orElseThrow(() -> {
					log.error("StudyPlan not found with id {}", id);
					return new CustomException(StudyPlanResponseConstant.STUDYPLAN_NOT_FOUND);
				});
	}

	public ResponseEntity<ResponseObject> getCreatedByAndSemesterAndYear(String username, String semester, Integer year) {
		try {
			List<Survey> surveyList = surveyRepository.findByCreatedByAndSemesterAndYear(username, semester, year);
			log.info("{} Survey fetched successfully from DB", surveyList.size());
			return buildSuccessResponse(com.eqa.eqasurveyservice.constant.StudyPlanResponseConstant.SURVEY_LIST_SUCCESS, surveyList);
		} catch (Exception ex) {
			log.error("Error while fetching Survey list by username {}", ex.getMessage());
			throw new CustomException(com.eqa.eqasurveyservice.constant.StudyPlanResponseConstant.SURVEY_LIST_FAILED);
		}
	}

}

