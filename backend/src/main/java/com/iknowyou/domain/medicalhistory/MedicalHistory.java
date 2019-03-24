package com.iknowyou.domain.medicalhistory;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.iknowyou.domain.patient.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="MEDICALHISTORY")
public class MedicalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="HISTORY_DATE")
	private LocalDateTime historyDate;
	@Column(name="NOTE")
	private String note;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Patient patient;
	
	
}
