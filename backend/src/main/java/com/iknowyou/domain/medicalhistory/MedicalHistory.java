package com.iknowyou.domain.medicalhistory;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iknowyou.domain.patient.Patient;
import com.iknowyou.infra.serializer.MedicalHistorySerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="MEDICALHISTORY")
@JsonSerialize(using= MedicalHistorySerializer.class)
public class MedicalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="HISTORY_DATE")
	private LocalDateTime historyDate;
	@Column(name="NOTE")
	private String note;
	
	@ManyToOne()
	private Patient patient;
	
	
}
