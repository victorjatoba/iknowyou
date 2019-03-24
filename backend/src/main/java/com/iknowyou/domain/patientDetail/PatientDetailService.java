package com.iknowyou.domain.patientDetail;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iknowyou.domain.medicalhistory.MedicalHistory;
import com.iknowyou.domain.patient.Patient;
import com.iknowyou.domain.patient.PatientService;
import com.iknowyou.watsonclient.WatsonKeywordsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientDetailService {

	private final PatientService patientService;
	private final WatsonKeywordsService watsonKeywordsService;
	
	public PatientDetail getPatientDetailById(final int patientId) {
		final Patient patient = patientService.findPatientById(patientId);
		final List<MedicalHistory> histories = patientService.findAllHistoryByPatientId(patientId);
		final String allHistory = histories.stream().map(MedicalHistory::getNote).collect(Collectors.joining(";"));
		final List<String> keywords = watsonKeywordsService.getKeywords(allHistory);
		final PatientDetail patientDetail = new PatientDetail(patient, keywords);
		return patientDetail;
	}
	
	
}
