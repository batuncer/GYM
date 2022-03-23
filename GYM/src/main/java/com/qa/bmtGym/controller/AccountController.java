package com.qa.bmtGym.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bmtGym.model.Accounts;
import com.qa.bmtGym.services.AccountService;

@RestController
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/account/create")
	public ResponseEntity<String> create(@RequestBody Accounts account){
		
		accountService.create(account);
		
		ResponseEntity<String> response = new ResponseEntity<>("Account created" , HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/account/getAccounts")
	public ResponseEntity<List<Accounts>> getAccountns(){
		List<Accounts> response = accountService.getAccounts();
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/account/delete/{id}")
	public ResponseEntity<String>deleteByid(@PathVariable("id") long id){
		
		accountService.remove(id);
		String response = "User of id: " + id + "deleted";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	@PutMapping("/account/update/{id}")
	public ResponseEntity<String>updateByid(@PathVariable("id") long id){
		accountService.update(id, null);
		String response = "Updating user of id: " + id;
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}
}
