package com.qa.bmtGym.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.bmtGym.model.Accounts;
import com.qa.bmtGym.model.GymMemberShip;

public interface GymMemberShipRepo extends JpaRepository<GymMemberShip, Long>{
	
	public List<GymMemberShip> findByIsdelete (boolean isdelete);

}
