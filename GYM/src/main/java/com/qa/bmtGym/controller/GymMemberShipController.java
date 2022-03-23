package com.qa.bmtGym.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/memberShip/pay")
	public ResponseEntity<String> pay(@RequestBody GymMemberShip memberShip){
		memberShipService.payMemberShip(memberShip.getUserId(), memberShip.getPeriodDate(), memberShip.getPrice());
		ResponseEntity<String> response = new ResponseEntity<>("MemberShip extended" , HttpStatus.CREATED);
		return response;
		
	}
	
}
