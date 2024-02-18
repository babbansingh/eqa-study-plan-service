package com.eqa.eqastudyplanservice.constant;

import org.springframework.http.HttpStatus;

public enum StudyPlanResponseConstant {

	TECHNICAL_ERROR("EQA-STUDYPLAN.0000", "Technical error occurred!", HttpStatus.INTERNAL_SERVER_ERROR),
	STUDYPLAN_CREATION_FAILED("EQA-STUDYPLAN.0001", "Error occurred while saving study plan.",
			HttpStatus.INTERNAL_SERVER_ERROR),
	STUDYPLAN_DELETION_FAILED("EQA-STUDYPLAN.0003", "Error occurred while deleting study plan.",
			HttpStatus.INTERNAL_SERVER_ERROR),
	STUDYPLAN_NOT_FOUND("EQA-STUDYPLAN.0004", "Study plan not found with given id", HttpStatus.NOT_FOUND),

	STUDYPLAN_NOT_FOUND_WITH_GIVEN_CRITERIA("EQA-STUDYPLAN.0004", "Study plan not found with given criteria", HttpStatus.NOT_FOUND),
	STUDYPLAN_BAD_REQUEST_ERROR("EQA-STUDYPLAN.0005","Invalid input!",HttpStatus.BAD_REQUEST),

	STUDYPLAN_CREATE_SUCCESS("EQA-STUDYPLAN.2000", "Study plan saved successfully.", HttpStatus.CREATED),

	STUDYPLAN_DATA_CREATE_SUCCESS("EQA-STUDYPLAN.3000", "Study plan data saved successfully.", HttpStatus.CREATED),
	STUDYPLAN_UPDATE_SUCCESS("EQA-STUDYPLAN.2001", "Study plan updated successfully.", HttpStatus.OK),

	STUDYPLAN_UPDATE_FAILED("EQA-STUDYPLAN.2002", "Study plan updated failed.", HttpStatus.OK),
	STUDYPLAN_DELETE_SUCCESS("EQA-STUDYPLAN.2003", "Study plan deleted successfully.", HttpStatus.OK),
	STUDYPLAN_SEARCH_SUCCESS("EQA-STUDYPLAN.2004", "Study plan fetched successfully.", HttpStatus.OK),
	STUDYPLAN_LIST_SUCCESS("EQA-STUDYPLAN.2005", "Study plan list fetched successfully.", HttpStatus.OK),
	STUDYPLAN_LIST_FAILED("EQA-STUDYPLAN.2008", "Error while fetching STUDYPLAN list.", HttpStatus.OK),

	STUDYPLAN_GET_FAILED("EQA-STUDYPLAN.2009", "Error while fetching STUDYPLAN.", HttpStatus.OK),
	STUDYPLAN_DATA_LIST_FAILED("EQA-STUDYPLAN.3008", "Error while fetching STUDYPLAN form data list.", HttpStatus.OK),

	STUDYPLAN_DATA_SEARCH_FAILED("EQA-STUDYPLAN.3009", "Error while searching STUDYPLAN form data.", HttpStatus.OK),

	STUDYPLAN_SEARCH_FAILED("EQA-STUDYPLAN.3009", "Error while searching STUDYPLAN form data.", HttpStatus.OK),
	STUDYPLAN_DATA_LIST_SUCCESS("EQA-STUDYPLAN.3005", "Study plan data list fetched successfully.", HttpStatus.OK),
	STUDYPLAN_GET_SUCCESS("EQA-STUDYPLAN.2006", "Study plan fetched successfully.", HttpStatus.OK),
	STUDYPLAN_DATA_GET_SUCCESS("EQA-STUDYPLAN.3006", "Study plan data fetched successfully.", HttpStatus.OK),

	STUDYPLAN_DATA_INCOMPLETE("EQA-STUDYPLAN.4006", "Study plan data is incomplete. Please submit complete STUDYPLAN data.", HttpStatus.BAD_REQUEST),

	STUDYPLAN_DATA_EXPIRED("EQA-STUDYPLAN.4007", "Study plan has been completed already or STUDYPLAN URL is expired.", HttpStatus.BAD_REQUEST);

	private String businessCode;

	private String businessMsg;

	private HttpStatus httpStatus;

	private StudyPlanResponseConstant(String businessCode, String businessMsg, HttpStatus httpStatus) {
		this.businessCode = businessCode;
		this.businessMsg = businessMsg;
		this.httpStatus = httpStatus;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessMsg() {
		return businessMsg;
	}

	public void setBusinessMsg(String businessMsg) {
		this.businessMsg = businessMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
