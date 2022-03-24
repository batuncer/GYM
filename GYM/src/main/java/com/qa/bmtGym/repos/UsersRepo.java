package com.qa.bmtGym.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.bmtGym.model.Users;

public interface UsersRepo extends JpaRepository<Users, Long>{
	
	public List<Users> findByIsdelete (boolean isdelete);

	


}
