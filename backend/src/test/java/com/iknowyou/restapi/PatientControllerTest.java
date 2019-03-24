package com.iknowyou.restapi;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import net.minidev.json.JSONValue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;
	
	
	@Test
	public void testFindAllPatients() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/patient"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		JSONAssert.assertEquals(getMvcResultAsString(mvcResult), getJsonAsString("expected/expected_all_patients.json"),true);

	}

	
	@Test
	public void testFindPatientById() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/patient/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		JSONAssert.assertEquals(getMvcResultAsString(mvcResult), getJsonAsString("expected/expected_patient_by_id.json"),true);
	}
	
	@Test
	public void testFindPatientByIdFail() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/patient/100"))
                .andExpect(MockMvcResultMatchers.status().isPreconditionFailed()).andReturn();
	}
	
	@Test
	public void testFindHistoryByPatientId() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/history/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		JSONAssert.assertEquals(getMvcResultAsString(mvcResult), getJsonAsString("expected/expected_history_by_patient_id.json"),true);

	}
	
	private String getMvcResultAsString(final MvcResult mvcResult) throws UnsupportedEncodingException {
	    return mvcResult.getResponse().getContentAsString();
    }

    private String getJsonAsString(final String fileName) {
	    final InputStream inputStream = getClass().getResourceAsStream(String.format("/%s", fileName));
	    return JSONValue.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).toString();
    }
}
