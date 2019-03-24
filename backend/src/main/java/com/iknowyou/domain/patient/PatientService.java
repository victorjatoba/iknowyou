package com.iknowyou.domain.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.iknowyou.domain.medicalhistory.MedicalHistory;
import com.iknowyou.domain.medicalhistory.MedicalHistoryRepository;

public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	MedicalHistoryRepository medicalRepository;
	
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}
	
	public Patient findPatientById(int patientId) {
		Optional<Patient> p = patientRepository.findById(patientId);
		return p.orElseThrow(() -> new PatientNotFoundException("Patient ID " + patientId + " not found"));
	}
	
	public List<MedicalHistory> findAllHistoryByPatientId(int patientId) {
		return medicalRepository.findAllByPatientId(patientId);
	}

}
