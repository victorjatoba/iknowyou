package com.iknowyou.domain.patient;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {

	@Autowired
	private PatientRepository repository;
	
	
	@Test
	public void test() {
		final List<Patient> patients = repository.findAll();
		assertEquals(6, patients.size());
		assertEquals("Luigi Scarminio", patients.get(0).getName());
		
		
	}

}
