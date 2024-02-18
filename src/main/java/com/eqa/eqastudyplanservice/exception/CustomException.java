package com.eqa.eqastudyplanservice.exception;

import com.eqa.eqastudyplanservice.constant.StudyPlanResponseConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private StudyPlanResponseConstant studyPlanResponseConstant;

	public CustomException(StudyPlanResponseConstant studyPlanResponseConstant) {
		super(studyPlanResponseConstant.getBusinessMsg());
		this.studyPlanResponseConstant = studyPlanResponseConstant;
	}
}
