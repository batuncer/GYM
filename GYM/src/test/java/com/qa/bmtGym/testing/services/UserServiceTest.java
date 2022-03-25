package com.qa.bmtGym.testing.services;



import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.bmtGym.model.Accounts;
import com.qa.bmtGym.model.Users;
import com.qa.bmtGym.repos.UsersRepo;
import com.qa.bmtGym.services.UserService;


@SpringBootTest
public class UserServiceTest {
	
	@MockBean
	private UsersRepo userRepo;
	
	@Autowired
	private UserService userService;
	

	Users user1 = new Users("baki",180,70,"baki@gmail.com","08111111",false);
	Users user2 = new Users("jack",190,80,"jack@gmail.com","07234243",false);
	
	Users userId1 = new Users(1l,"baki",180,70,"baki@gmail.com","08111111",false);
	Users userId2 = new Users(2l,"jack",190,80,"jack@gmail.com","07234243",false);
	Users userId1Updated= new Users(1l,"baki",185,70,"baki@gmail.com","08111111",false);

		//create, getUsers,deleteById,updateById
	@Test
	public void testUserCreate() {
		Mockito.when(userRepo.save(user1)).thenReturn(userId1);
		Users result = userService.create(user1);
		
		System.out.println(result);
		System.out.println(user1);
		
		Assertions.assertEquals(userId1, result);
		Mockito.verify(userRepo,Mockito.times(1)).save(user1);
		
		Mockito.when(userRepo.save(user2)).thenReturn(userId2);
		Users result2 = userService.create(user2);
		
		System.out.println(result2);
		System.out.println(user2);
		
		Assertions.assertEquals(userId2, result2);
		Mockito.verify(userRepo,Mockito.times(1)).save(user2);
		
	}
	
	@Test  
	public void testGetUsers(){
		List<Users> lst = List.of(userId1,userId2);
		Mockito.when(userRepo.findByIsdelete(false)).thenReturn(lst);
		
		List<Users> lists = userService.getUsers();
		Assertions.assertEquals(lst, lists);
		
		Mockito.verify(userRepo,Mockito.times(1)).findByIsdelete(false);
		
		
	}
	
	@Test
	public void testGetById() {
	
	Mockito.when(userRepo.findById(1l)).thenReturn(Optional.of(userId1));

	// Act
	Users result = userService.getById(1l);

	// Assert
	Assertions.assertEquals(userId1, result);

	
	Mockito.verify(userRepo, Mockito.times(1)).findById(1l);
}
	@Test
	public void testUpdateById() {
		
		userId1.setHeight(185);
		Mockito.when(userRepo.save(userId1)).thenReturn(userId1Updated);
		
		Users result = userRepo.save(userId1);
		
		Assertions.assertEquals(userId1, result);
		
		Mockito.verify(userRepo, Mockito.times(1)).save(userId1);
		
	}
	
	/*
	 * @Test public void testRemove() {
	 * Mockito.when(userRepo.save(user1)).thenReturn(userId1); Users result =
	 * userService.create(user1);
	 * 
	 * System.out.println(result); System.out.println(user1);
	 * 
	 * Assertions.assertEquals(userId1, result); userService.remove(result.getId());
	 * Mockito.verify(userService, Mockito.times(1)).remove(result.getId());
	 * 
	 * }
	 */

}