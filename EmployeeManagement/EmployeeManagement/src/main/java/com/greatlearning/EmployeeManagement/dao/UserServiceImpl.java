package com.greatlearning.EmployeeManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entities.Users;
import com.greatlearning.EmployeeManagement.repo.UserRepository;
import com.greatlearning.EmployeeManagement.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(Users users) {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(users);
	}

}
