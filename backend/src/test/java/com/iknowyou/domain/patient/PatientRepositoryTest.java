package com.iknowyou.domain.patient;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class PatientRepositoryTest {

	@Autowired
	private PatientRepository repository;
	
	
	@Test
	public void test() {
		final Collection<Patient> patients = repository.findAll();
		assertEquals(1, patients.size());
		
		
		
	}

}
