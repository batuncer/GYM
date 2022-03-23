package com.qa.bmtGym.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
		
		return repo.findByIsDelete(false);
		
	}
	
	public boolean update(long id, Users user) {
		Users oldUser = getById(id);
		
		oldUser.setTelNumber(user.getTelNumber());
		oldUser.setEmail(user.getEmail());
		oldUser.setId(user.getId());
		oldUser.setDelete(user.isDelete());
		repo.save(oldUser);
	
		
		return true;
		
	}
	
	public boolean remove(long id) {
		repo.deleteById(null);
		return true;
	}

}
