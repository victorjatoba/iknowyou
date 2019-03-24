package com.iknowyou.domain.patient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iknowyou.infra.exception.ApplicationException;

@ResponseStatus(code=HttpStatus.PRECONDITION_FAILED, reason= "PATIENT_NOT_FOUND")
public class PatientNotFoundException extends ApplicationException {
	public PatientNotFoundException(String message) {
		super(message);
	}
}
