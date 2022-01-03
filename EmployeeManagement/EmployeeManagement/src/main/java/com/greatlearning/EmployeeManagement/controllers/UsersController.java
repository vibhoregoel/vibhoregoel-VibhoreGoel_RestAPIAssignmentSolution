package com.greatlearning.EmployeeManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.EmployeeManagement.entities.Roles;
import com.greatlearning.EmployeeManagement.entities.Users;
import com.greatlearning.EmployeeManagement.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public String showHome(Model model) {
		
		return "home";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Users users = new Users();
		model.addAttribute("Users", users);
		
		return "add-user";
	}
	
	@Bean
	private BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		String bcryptPassword = encoder().encode(password);
		
		Users users = new Users(username, bcryptPassword);
		userService.saveUser(users);
		
		return "redirect:/users/home";
	}
	
}
