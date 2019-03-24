package com.iknowyou.domain.medicalhistory;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalHistoryRepositoryTest {

	@Autowired
	MedicalHistoryRepository repository;
	
	
	@Test
	public void test() {
		final List<MedicalHistory> histories = repository.findAllByPatientId(1);
		assertEquals(3, histories.size());
		
		
	}

}
