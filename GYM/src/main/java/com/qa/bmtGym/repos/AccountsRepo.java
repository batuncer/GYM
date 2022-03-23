package com.qa.bmtGym.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.bmtGym.model.Accounts;


public interface AccountsRepo extends JpaRepository<Accounts, Long> {
	
	
	public List<Accounts> findByIsdelete (boolean isdelete);

	
}
