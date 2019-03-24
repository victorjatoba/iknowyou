package com.iknowyou.domain.medicalhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {

	List<MedicalHistory> findAllByPatientId(int patiendId);
	
	
}
