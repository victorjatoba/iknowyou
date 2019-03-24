package com.iknowyou.domain.patient;

import java.util.LinkedList;
import java.util.List;

import com.iknowyou.domain.medicalhistory.MedicalHistory;

public class PatientService {
	
	public List<Patient> getAllPatients() {
		List<Patient> list = new LinkedList<>();
		for (int i=0; i<15; i++) {
			List<MedicalHistory> history = new LinkedList<>();
			Patient p = new Patient(i, "name"+i, i+10, "bloodType"+i, "address"+i, "phone"+i, "emergencyContact"+i,history);
			list.add(p);
		}
		
		return list;
	}
	
	public List<MedicalHistory> getHistoryByPatientId(int patientId) {
		List<Patient> list = new LinkedList<>();
		for (int i=0; i<15; i++) {
			List<MedicalHistory> history = new LinkedList<>();
			Patient p = new Patient(i, "name"+i, i+10, "bloodType"+i, "address"+i, "phone"+i, "emergencyContact"+i,history);
			list.add(p);
		}
		
		for (int j=0; j<list.size();j++) {
			if (list.get(j).getId() == patientId) {
				return list.get(j).getHistories();
			}
		}
		
		return null;
		
	}

}
