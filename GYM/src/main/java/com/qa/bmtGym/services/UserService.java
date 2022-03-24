package com.qa.bmtGym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.bmtGym.StringOutOfRangeException;
import com.qa.bmtGym.model.Users;
import com.qa.bmtGym.repos.UsersRepo;

@Service
public class UserService {
	
	private UsersRepo repo;

	public UserService(UsersRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Users create(Users user) {
		Users createObject = repo.save(user);
		return createObject;
		
	}
	
	public Users getById(long id) {
		return repo.findById(id).get();
		
	}
	
	public List<Users> getUsers(){
		
		return repo.findByIsdelete(false);
		
	}
	
	public boolean update(long id, Users user) throws StringOutOfRangeException {
		if(user.getFullName().length() > 50)
			throw new StringOutOfRangeException("this file more than 50");
		Users oldUser = getById(id);
		
		oldUser.setFullName(user.getFullName());
		oldUser.setTelNumber(user.getTelNumber());
		oldUser.setEmail(user.getEmail());
		oldUser.setDelete(user.isdelete());
		Users updateUser = oldUser;
		repo.save(updateUser);
	
		
		return true;
		
	}
	
	public boolean remove(long id) {
		Users oldUser = getById(id);
		oldUser.setDelete(true);
		repo.save(oldUser);
		return true;
	}

}
