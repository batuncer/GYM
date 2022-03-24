package com.qa.bmtGym.testing.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.bmtGym.model.GymMemberShip;
import com.qa.bmtGym.model.GymMemberShip.membershipType;
import com.qa.bmtGym.repos.GymMemberShipRepo;
import com.qa.bmtGym.services.GymMemberShipService;




@SpringBootTest
public class GymMemberShipServiceTest {
	
	@MockBean
	private GymMemberShipRepo memberRepo;
	
	@Autowired
	private GymMemberShipService GymMemberShipservice;
	

	

		//create, getGymMemberShips,deleteById,updateById
	@Test
	public void testUserCreate() throws ParseException {
		GymMemberShip testGymMemberShip1 = new GymMemberShip(1l,1l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);
		GymMemberShip testGymMemberShipId1 = new GymMemberShip(1l,1l,1l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);

		Mockito.when(memberRepo.save(testGymMemberShip1)).thenReturn(testGymMemberShipId1);
		GymMemberShip result = GymMemberShipservice.createMemberShip(testGymMemberShip1.getUserId(), testGymMemberShip1.getaccountId(), testGymMemberShip1.getPeriodDate(), testGymMemberShip1.getCreateDate(), testGymMemberShip1.getmType(), testGymMemberShip1.getPrice());
		
		System.out.println(result);
		System.out.println(testGymMemberShip1);
		
		Assertions.assertEquals(testGymMemberShipId1, result);
		Mockito.verify(memberRepo,Mockito.times(1)).save(testGymMemberShip1);
		
		
		
	}
	
	@Test
	public void testGetById() throws ParseException {
		GymMemberShip testGymMemberShip1 = new GymMemberShip(1l,1l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);
		GymMemberShip testGymMemberShipId1 = new GymMemberShip(1l,1l,1l,25f,membershipType.standart,this.ConvertDate("2022-03-24 21:00"),30,this.ConvertDate("2022-03-24 21:00"),false);

	Mockito.when(memberRepo.findById(1l)).thenReturn(Optional.of(testGymMemberShipId1));

	// Act
	GymMemberShip result = GymMemberShipservice.getById(1l);

	// Assert
	Assertions.assertEquals(testGymMemberShipId1, result);

	
	Mockito.verify(memberRepo, Mockito.times(1)).findById(1l);
}

	
	private Date ConvertDate(String strDate) throws ParseException {
		
		SimpleDateFormat _formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
		Date d = _formatter.parse(strDate);
		return d;
	}
//	@Test
//	public void testRemove() {
//		Mockito.when(userRepo.save(user1)).thenReturn(userId1);
//		GymMemberShips result = GymMemberShipservice.create(user1);
//		
//		System.out.println(result);
//		System.out.println(user1);
//		
//		Assertions.assertEquals(userId1, result);
//		GymMemberShipservice.remove(result.getId());
//		Mockito.verify(GymMemberShipservice, Mockito.times(1)).remove(result.getId());
//		
//	
//	}

}