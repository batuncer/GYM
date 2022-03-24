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

import com.qa.bmtGym.StringOutOfRangeException;
import com.qa.bmtGym.model.Users;
import com.qa.bmtGym.services.UserService;

@RestController
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/user/create")
	public ResponseEntity<String> create(@RequestBody Users user){
		userService.create(user);
		ResponseEntity<String> response = new ResponseEntity<>("User created" , HttpStatus.CREATED);
		
		return response;
	}
	
	@GetMapping("/user/getUsers")
	public ResponseEntity<List<Users>> getUsers(){
		
		List<Users> response = userService.getUsers();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<String>deleteByid(@PathVariable("id") long id){
		userService.remove(id);
		String response = "User of id: " + id + "deleted";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
		
	}
	
	@PutMapping("/user/update/{id}")
	public ResponseEntity<String> updateByid(@PathVariable("id") long id, @RequestBody Users user) throws StringOutOfRangeException{
		userService.update(id, user);
		String response = "Updating user of id:" + id;
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
}
