package com.qa.bmtGym.testing.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.qa.bmtGym.model.Accounts;
import com.qa.bmtGym.model.Users;
import com.qa.bmtGym.repos.AccountsRepo;
import com.qa.bmtGym.services.AccountService;

@SpringBootTest
public class AccountServiceTest {

	@MockBean
	private AccountsRepo accountRepo;
	
	@Autowired
	private AccountService accountService;
	
	Accounts account1 = new Accounts("test1","1234","test1@mail.com","44 7456 000000","test road t1 s23 london",25,false);
	Accounts account2 = new Accounts("test2","1234","test2@mail.com","44 7456 000001","test road t2 s23 london",25,false);
	
	Accounts accountId1 = new Accounts(1l,"test1","1234","test1@mail.com","44 7456 000000","test road t1 s23 london",25,false);
	Accounts accountId2 = new Accounts(2l,"test2","1234","test2@mail.com","44 7456 000001","test road t2 s23 london",25,false);
	Accounts accountId1Updated= new Accounts(1l,"test1","1234","tuncer@gmail.com","44 7456 000000","test road t1 s23 london",25,false);
	// create, getAccounts, delete, update, 
	
	@Test
	public void testCreate() {
	Mockito.when(accountRepo.save(account1)).thenReturn(accountId1);
	Accounts result = accountService.create(account1);

	System.out.println(result);
	System.out.println(account1);
	
	Assertions.assertEquals(accountId1, result);
	Mockito.verify(accountRepo,Mockito.times(1)).save(account1);

	
	Mockito.when(accountRepo.save(account2)).thenReturn(accountId2);
	Accounts result2 = accountService.create(account2);

	System.out.println(result2);
	System.out.println(account2);
	
	Assertions.assertEquals(accountId2, result2);
	Mockito.verify(accountRepo,Mockito.times(1)).save(account2);
	
	
	}
	
	
	
	@Test  
	public void testGetAccounts(){
		List<Accounts> lst = List.of(accountId1,accountId2);
		Mockito.when(accountRepo.findByIsdelete(false)).thenReturn(lst);
		
		List<Accounts> lists = accountService.getAccounts();
		Assertions.assertEquals(lst, lists);
		
		Mockito.verify(accountRepo,Mockito.times(1)).findByIsdelete(false);
		
		
	}
	
	@Test
	public void testAccountUpdateById() {
		
		accountId1.setEmail("tuncer@gmail.com");
		Mockito.when(accountRepo.save(accountId1)).thenReturn(accountId1Updated);
		
		Accounts result = accountRepo.save(accountId1);
		
		Assertions.assertEquals(accountId1, result);
		
		Mockito.verify(accountRepo, Mockito.times(1)).save(accountId1);
		
	}
	
	@Test
	public void testGetById() {
	
	Mockito.when(accountRepo.findById(1l)).thenReturn(Optional.of(accountId1));

	// Act
	Accounts result = accountService.getByAccountId(1l);

	// Assert
	Assertions.assertEquals(accountId1, result);

	
	Mockito.verify(accountRepo, Mockito.times(1)).findById(1l);
}
	
	@Test
	public void testRemove() {
		Mockito.when(accountRepo.save(account1)).thenReturn(accountId1);
		Accounts result = accountService.create(account1);

		System.out.println(result);
		System.out.println(account1);
		
		Assertions.assertEquals(accountId1, result);
		long c = accountId1.getId();
		System.out.println(c);
		boolean resultr = accountService.remove(c);
		
		Assertions.assertEquals(true, resultr);
		
	
		
	
	}
}
