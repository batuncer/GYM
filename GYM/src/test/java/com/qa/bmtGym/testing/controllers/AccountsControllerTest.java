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
import com.qa.bmtGym.model.Accounts;


 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 

@Sql(scripts = {"classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev") 


public class AccountsControllerTest {
	
	@Autowired  
	private MockMvc mvc; 
	
	@Autowired 
	private ObjectMapper mapper;
	
	Accounts testAccount = new Accounts("testname","12345", "jack@gmail.com", "1231232", "albion street",
			25, false);
	
	Accounts account1 = new Accounts("test1","1234","test1@mail.com","44 7456 000000","test road t1 s23 london",25,false);
	Accounts accountId1 = new Accounts(1l,"test1","1234","test1@mail.com","44 7456 000000","test road t1 s23 london",25,false);
	Accounts accountId2 = new Accounts(2l,"test2","1234e3","test3@mail.com","43 7456 000001","test3 road t2 s23 london",25,false);

	@Test
	public void testCreate() throws Exception {
		
		String accountJson = mapper.writeValueAsString(testAccount);
		RequestBuilder req = post("/account/create").contentType(MediaType.APPLICATION_JSON).content(accountJson);
		
		ResultMatcher checkStatus = status().isCreated(); 
		ResultMatcher checkBody = content().string("Account created");
	
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	
	
	 @Test public void testDeleteId() throws Exception { RequestBuilder req =
	 delete("/account/delete/1");
	  
	  ResultMatcher checkStatus = status().isAccepted(); ResultMatcher checkBody =
	  content().string("Account of id: " + 1 + "deleted");
	  
	  mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); }
	
	
	@Test
	public void testGetAll() throws Exception {

		
		List<Accounts> allAccounts = List.of(accountId1, accountId2); // creating a list which contains these objects

		
		String allBookingsJson = mapper.writeValueAsString(allAccounts);

		
		RequestBuilder req = get("/account/getAccounts");

		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(allBookingsJson); // If not valid, we'll be able to see the exact response

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	@Test
	public void testUpdate() throws Exception {

		// Arrange
	
		Accounts updatedAccount = new Accounts("test1","newpassword","test1@mail.com","44 7456 000000","test road t1 s23 london",25,false);

		// Converting our object to JSON
		String updatedAccountJson = mapper.writeValueAsString(updatedAccount);

		// requestBuilder takes in the , request type, Path and JSON object
		RequestBuilder req = put("/account/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedAccountJson);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("Updating account of id: 1");

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	
	
	
}


