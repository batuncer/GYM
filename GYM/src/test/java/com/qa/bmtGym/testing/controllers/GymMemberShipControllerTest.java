package com.qa.bmtGym.testing.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.http.MediaType;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bmtGym.model.GymMemberShip;
import com.qa.bmtGym.model.GymMemberShip.membershipType;


 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 

@Sql(scripts = {"classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev") 


public class GymMemberShipControllerTest {
	
	@Autowired  
	private MockMvc mvc; 
	
	@Autowired 
	private ObjectMapper mapper;

	
	
	
	
	


	@Test
	public void testCreate() throws Exception {
		
		GymMemberShip testGymMemberShip1 = new GymMemberShip(1l,1l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);
		
		String GymMemberShipJson = mapper.writeValueAsString(testGymMemberShip1);
		RequestBuilder req = post("/membership/create").contentType(MediaType.APPLICATION_JSON).content(GymMemberShipJson);
		
		ResultMatcher checkStatus = status().isCreated(); 
		ResultMatcher checkBody = content().string("New membership created");
	
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	
	

	
	
	@Test
	public void testGetAll() throws Exception {

		GymMemberShip testGymMemberShipId1 = new GymMemberShip(1l,1l,1l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);
		GymMemberShip testGymMemberShipId2 = new GymMemberShip(2l,2l,2l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);
		
		List<GymMemberShip> allGymMemberShip = List.of(testGymMemberShipId1, testGymMemberShipId2); // creating a list which contains these objects

		
		String allBookingsJson = mapper.writeValueAsString(allGymMemberShip);

		
		RequestBuilder req = get("/membership/getMemberShip");

		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(allBookingsJson); // If not valid, we'll be able to see the exact response

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	@Test
	public void testPay() throws Exception {

		// Arrange
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
		Date date = formatter.parse("2022-03-24 21:00");
		GymMemberShip updatedGymMemberShip = new GymMemberShip(1l,1l,25f,membershipType.standart,date,30,date,false);

		// Converting our object to JSON
		String updatedGymMemberShipJson = mapper.writeValueAsString(updatedGymMemberShip);

		// requestBuilder takes in the , request type, Path and JSON object
		RequestBuilder req = put("/membership/pay/1").contentType(MediaType.APPLICATION_JSON).content(updatedGymMemberShipJson);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("MemberShip extended");

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	private Date ConvertDate(String strDate) throws ParseException {
		
		SimpleDateFormat _formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
		Date d = _formatter.parse(strDate);
		return d;
	}
}
