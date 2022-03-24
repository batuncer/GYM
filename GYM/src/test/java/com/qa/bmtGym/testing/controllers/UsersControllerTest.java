package com.qa.bmtGym.testing.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import com.qa.bmtGym.model.Users;


 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 

@Sql(scripts = {"classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev") 


public class UsersControllerTest {
	
	@Autowired  
	private MockMvc mvc; 
	
	@Autowired 
	private ObjectMapper mapper;
	
	Users testuser = new Users("test",180,70,"baki@gmail.com","08111111",false);
	
	Users user1 = new Users("baki",180,70,"baki@gmail.com","08111111",false);
	Users userId1 = new Users(1l,"test",180,70,"baki@gmail.com","08111111",false);
	Users userId2 = new Users(2l,"jack",190,80,"jack@gmail.com","07234243",false);

	@Test
	public void testCreate() throws Exception {
		
		String userJson = mapper.writeValueAsString(testuser);
		RequestBuilder req = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(userJson);
		
		ResultMatcher checkStatus = status().isCreated(); 
		ResultMatcher checkBody = content().string("User created");
	
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	
	
	 @Test public void testDeleteId() throws Exception { 
		 RequestBuilder req = delete("/user/delete/1");
	  
	  ResultMatcher checkStatus = status().isAccepted(); 
	  ResultMatcher checkBody =  content().string("User of id: 1deleted");
	  
	  mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); }
	
	
	@Test
	public void testGetAll() throws Exception {

		
		List<Users> allUsers = List.of(userId1, userId2); // creating a list which contains these objects

		
		String allBookingsJson = mapper.writeValueAsString(allUsers);

		
		RequestBuilder req = get("/user/getUsers");

		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(allBookingsJson); // If not valid, we'll be able to see the exact response

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	@Test
	public void testUpdate() throws Exception {

		// Arrange
	
		Users updateduser = new Users("test",180,70,"baki@gmail.com","08111111",false);

		// Converting our object to JSON
		String updateduserJson = mapper.writeValueAsString(updateduser);

		// requestBuilder takes in the , request type, Path and JSON object
		RequestBuilder req = put("/user/update/1").contentType(MediaType.APPLICATION_JSON).content(updateduserJson);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("Updating user of id:1");

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
}
