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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PATIENT")
public class Patient {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	@Column(name="AGE")
	private Integer age;
	@Column(name="BLOODTYPE")
	private String bloodType;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMERGENCYCONTACT")
	private String emergencyContact;
	
	@OneToMany(mappedBy="patient")
	@Setter(AccessLevel.NONE)
	private List<MedicalHistory> histories = new LinkedList<>();
	
	public List<MedicalHistory> getHistories() {
		return Collections.unmodifiableList(histories);
	}
	
	public void addMedicalHistory(final MedicalHistory medicalHistory) {
		histories.add(medicalHistory);
	}
	
	
}
