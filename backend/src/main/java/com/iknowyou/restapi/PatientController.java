package com.iknowyou.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iknowyou.domain.medicalhistory.MedicalHistory;
import com.iknowyou.domain.patient.Patient;
import com.iknowyou.domain.patient.PatientService;
import com.iknowyou.domain.patientDetail.PatientDetail;
import com.iknowyou.domain.patientDetail.PatientDetailService;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	PatientDetailService patientDetailService;
	
	@GetMapping("/patient")
	public List<Patient> findAllPatitents() {
		return patientService.findAllPatients();
	}
	
	@GetMapping("/patient/{id}")
	public Patient findPatientById(@PathVariable("id") final int id) {
		return patientService.findPatientById(id);
	}
	
	@GetMapping("/history/{id}")
	public List<MedicalHistory> findAllHistoryByPatientId(@PathVariable("id") final int id) {
		return patientService.findAllHistoryByPatientId(id);
	}

	@GetMapping("patientdetail/{id}")
	public PatientDetail findPatientDetailById(@PathVariable("id") final int id) {
		return patientDetailService.getPatientDetailById(id);
	}
	
}
