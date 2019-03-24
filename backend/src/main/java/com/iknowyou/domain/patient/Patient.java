package com.iknowyou.domain.patient;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.iknowyou.domain.medicalhistory.MedicalHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String name;
	@Column
	private Integer age;
	@Column
	private String bloodType;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private String emergencyContact;
	
	@OneToMany(mappedBy="patient")
	private List<MedicalHistory> histories = new LinkedList<>();
	
	public List<MedicalHistory> getHistories() {
		return Collections.unmodifiableList(histories);
	}
	
	public void addMedicalHistory(final MedicalHistory medicalHistory) {
		histories.add(medicalHistory);
	}
	
	
}
