package com.qa.bmtGym.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bmtGym.model.GymMemberShip;
import com.qa.bmtGym.services.GymMemberShipService;

@RestController
public class GymMemberShipController {
	
	private GymMemberShipService memberShipService;

	public GymMemberShipController(GymMemberShipService memberShipService) {
		super();
		this.memberShipService = memberShipService;
	}
	
	
	@PostMapping("/membership/create")
	public ResponseEntity<String> create(@RequestBody GymMemberShip membership){
		memberShipService.createMemberShip(membership.getUserId(), membership.getaccountId(), membership.getPeriodDate(), membership.getStartDate() ,membership.getmType(), membership.getPrice());
		ResponseEntity<String> response = new ResponseEntity<>("New membership created" , HttpStatus.CREATED);
		
		return response;
	}

	@GetMapping("/membership/getMemberShip")
	public ResponseEntity<List<GymMemberShip>> getMemberShip(){
		
		List<GymMemberShip> response = memberShipService.getMemberShip();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/membership/pay/{id}")
	public ResponseEntity<String> pay(@PathVariable("id") long id,@RequestBody GymMemberShip memberShip){
		memberShipService.payMemberShip(id, memberShip.getPeriodDate(), memberShip.getPrice());
		ResponseEntity<String> response = new ResponseEntity<>("MemberShip extended" , HttpStatus.ACCEPTED);
		return response;
		
	}
	
}
