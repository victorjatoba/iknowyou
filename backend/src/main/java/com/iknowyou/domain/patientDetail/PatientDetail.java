package com.iknowyou.domain.patientDetail;

import java.util.List;

import com.iknowyou.domain.patient.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDetail {

	private Patient patient;
	private List<String> keywords;
	
}
