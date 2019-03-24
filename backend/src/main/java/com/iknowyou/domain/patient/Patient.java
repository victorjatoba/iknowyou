package com.iknowyou.domain.patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	/*
	@OneToMany(mappedBy="patient", fetch=FetchType.LAZY)
	@Setter(AccessLevel.NONE)
	private List<MedicalHistory> histories = new LinkedList<>();
	
	public List<MedicalHistory> getHistories() {
		return Collections.unmodifiableList(histories);
	}
	
	public void addMedicalHistory(final MedicalHistory medicalHistory) {
		histories.add(medicalHistory);
	}
	*/
	
}
