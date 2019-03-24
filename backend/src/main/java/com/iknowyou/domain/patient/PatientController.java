package com.iknowyou.domain.patient;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iknowyou.domain.medicalhistory.MedicalHistory;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@GetMapping("/patient")
	public List<Patient> findAllPatitents() {
		PatientService ps = new PatientService();
		return ps.findAllPatients();
	}
	
	@GetMapping("/patient/{id}")
	public Patient findPatientById(@PathVariable("id") final int id) {
		PatientService ps = new PatientService();
		return ps.findPatientById(id);
	}
	
	@GetMapping("/history/{id}")
	public List<MedicalHistory> findAllHistoryByPatientId(@PathVariable("id") final int id) {
		PatientService ps = new PatientService();
		return ps.findAllHistoryByPatientId(id);
	}

}
