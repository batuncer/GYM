package com.qa.bmtGym.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.bmtGym.model.GymMemberShip;
import com.qa.bmtGym.repos.GymMemberShipRepo;

@Service
public class GymMemberShipService {

	GymMemberShipRepo memberShipRepo;
	
	
	public GymMemberShipService(GymMemberShipRepo memberShipRepo) {
		super();
		this.memberShipRepo = memberShipRepo;
	}


	public GymMemberShip createMemberShip(long userId,long accountId,int timePeriod,Date startDate,GymMemberShip.membershipType memberType,float price) {
		
		
	 return	this.memberShipRepo.save(new GymMemberShip(userId, accountId, price, memberType, startDate, timePeriod, startDate, false));
	}
	
	public List<GymMemberShip> getMemberShip(){
		return memberShipRepo.findByIsDelete(false);
	}
	
	public boolean payMemberShip(long id, int periodDate, float price) {
		
		GymMemberShip oldMemberShip = getById(id);
		
		oldMemberShip.setPeriodDate(periodDate);
		oldMemberShip.setPrice(price);
		oldMemberShip.setCreateDate(new Date());
		memberShipRepo.save(oldMemberShip);
		
		return true;
		
	}


	public GymMemberShip getById(long id) {
		
		return memberShipRepo.findById(id).get();
	}



	
}
