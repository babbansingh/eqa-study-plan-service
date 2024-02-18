package com.eqa.eqastudyplanservice.exception;

import com.eqa.eqastudyplanservice.constant.StudyPlanResponseConstant;
import com.eqa.eqastudyplanservice.util.CommonUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionAdviceHandler {

	private static final String STATUS = "Failed";
	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<?> handleStudyPlanException(CustomException exception) {

		return CommonUtils.buildResponseEntity(Arrays.asList(exception.getStudyPlanResponseConstant().getBusinessMsg()),
				STATUS, String.valueOf(Math.round(Math.random() * 100)), null,
				exception.getStudyPlanResponseConstant().getHttpStatus().value() + "",
				exception.getStudyPlanResponseConstant().getBusinessMsg(), new HttpHeaders(),
				exception.getStudyPlanResponseConstant().getHttpStatus());

	}
	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleBindException(BindException ex) {
		List<String> errorMsgList = new ArrayList<>();
		ex.getFieldErrors().forEach(error -> {
			errorMsgList.add(error.getDefaultMessage());
		});

		return CommonUtils.buildResponseEntity(errorMsgList,
				StudyPlanResponseConstant.STUDYPLAN_BAD_REQUEST_ERROR.getHttpStatus().getReasonPhrase(),
				String.valueOf(Math.round(Math.random() * 100)), null,
				StudyPlanResponseConstant.STUDYPLAN_BAD_REQUEST_ERROR.getHttpStatus().value() + "",
				StudyPlanResponseConstant.STUDYPLAN_BAD_REQUEST_ERROR.getBusinessMsg(), new HttpHeaders(),
				StudyPlanResponseConstant.STUDYPLAN_BAD_REQUEST_ERROR.getHttpStatus());
	}

}
