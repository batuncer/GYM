package com.qa.bmtGym.services;

import com.qa.bmtGym.repos.AccountsRepo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.bmtGym.model.Accounts;

@Service
public class AccountService {

	private AccountsRepo repo;
	

	public AccountService(AccountsRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	public Accounts create(Accounts account) {
		Accounts createObject = repo.save(account);
		return createObject;
		
	}
	
	public Accounts getById(long id) {
		return repo.findById(id).get();
	}
	
	public List<Accounts> getAccounts(){
		return repo.findByIsdelete(false);
		
	}
	
	public boolean remove(long id) {
		Accounts model = repo.getById(id);
		model.setIsdelete(true);
		repo.save(model);
		return true;
	}

	public boolean deleteAll() {
		repo.deleteAll();
		return true;
	}
	
	public boolean update(long id, Accounts account) {
		
		//Find the object we want to update
		Accounts oldAccount = getById(id);
		
		oldAccount.setAccountName(account.getAccountName());
		oldAccount.setAccountPassword(account.getAccountPassword());
		oldAccount.setEmail(account.getEmail());
		oldAccount.setIsdelete(account.isIsdelete());
		oldAccount.setTelNumber(account.getTelNumber());
		
		// Creating a new account with the value of oldAccount
		Accounts updateAccount= oldAccount;
		
		repo.save(updateAccount);
		return true;
	}
	
}
