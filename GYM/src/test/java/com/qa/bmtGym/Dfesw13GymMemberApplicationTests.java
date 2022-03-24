package com.qa.bmtGym;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.bmtGym.controller.AccountController;
import com.qa.bmtGym.controller.GymMemberShipController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Dfesw13GymMemberApplicationTests {

	@Autowired
	private GymMemberShipController memberShipController;
	
	@Autowired
	private AccountController accountController;
	
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(memberShipController).isNotNull();
		assertThat(accountController).isNotNull();
	}

}
