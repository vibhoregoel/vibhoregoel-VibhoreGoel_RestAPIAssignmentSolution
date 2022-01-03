package com.greatlearning.EmployeeManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.EmployeeManagement.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users getByUsername(String password);
	
	List<Users> findByIdContainsAndUsernameContainsAllIgnoreCase(int id, String username);
}
