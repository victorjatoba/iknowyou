package com.iknowyou.domain.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iknowyou.domain.medicalhistory.MedicalHistory;
import com.iknowyou.domain.medicalhistory.MedicalHistoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
	
	private final PatientRepository patientRepository;
	private final MedicalHistoryRepository medicalRepository;
	
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}
	
	public Patient findPatientById(final int patientId) {
		final Optional<Patient> p = patientRepository.findById(patientId);
		return p.orElseThrow(() -> new PatientNotFoundException("Patient ID " + patientId + " not found"));
	}
	
	public List<MedicalHistory> findAllHistoryByPatientId(final int patientId) {
		return medicalRepository.findAllByPatientId(patientId);
	}

}
