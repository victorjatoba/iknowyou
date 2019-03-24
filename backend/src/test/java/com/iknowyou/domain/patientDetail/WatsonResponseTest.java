package com.iknowyou.domain.patientDetail;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iknowyou.watsonclient.WatsonKeywordsService;

public class WatsonResponseTest {
	WatsonKeywordsService wqs;
	
	@Before
	public void setUp() throws Exception {
		wqs = new WatsonKeywordsService();
	}

	@Test
	public void test() {
		final List<String> keywors = wqs.getKeywords("The patients complains about continuous headache after being hit by a falling tree. Took on Aspirin.");
		assertTrue(keywors.size() > 0);
	}


}
