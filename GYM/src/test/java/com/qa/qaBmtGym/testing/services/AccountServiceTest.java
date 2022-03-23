package com.qa.qaBmtGym.testing.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.qa.bmtGym.repos.AccountsRepo;
import com.qa.bmtGym.services.AccountService;

@SpringBootTest
public class AccountServiceTest {

	@MockBean
	private AccountsRepo accountRepo;
	
	@Autowired
	private AccountService accountService;
	
	
	
	
}
