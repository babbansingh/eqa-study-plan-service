package com.eqa.eqastudyplanservice.util;

import com.ams.core.common.utilities.IdGenerator;
import com.eqa.eqastudyplanservice.constant.StudyPlanResponseConstant;
import com.eqa.eqastudyplanservice.model.ResponseObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {

	private CommonUtils() {
	}

	public static ResponseEntity<ResponseObject> buildResponseEntity(List<String> message, String status, String id,
																	 Object obj, String code, String error, HttpHeaders headers, HttpStatus httpStatus) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setMessage(message);
		responseObject.setTransactionId(IdGenerator.generateTransactionId());
		responseObject.setStatus(status);
		responseObject.setObj(obj);
		responseObject.setError(error);
		responseObject.setCode(code);
		responseObject.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(responseObject, headers, httpStatus);
	}
	public static ResponseEntity<ResponseObject> buildSuccessResponse(StudyPlanResponseConstant responseConstant, Object data) {
		return buildResponseEntity(
				Arrays.asList(responseConstant.getBusinessMsg()),
				responseConstant.getHttpStatus().getReasonPhrase(),
				String.valueOf(Math.round(Math.random() * 100)),
				data,
				String.valueOf(responseConstant.getHttpStatus().value()),
				null,
				new HttpHeaders(),
				responseConstant.getHttpStatus()
		);
	}

}
