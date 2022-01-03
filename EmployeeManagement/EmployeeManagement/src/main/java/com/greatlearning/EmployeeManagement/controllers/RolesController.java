package com.greatlearning.EmployeeManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.EmployeeManagement.entities.Roles;
import com.greatlearning.EmployeeManagement.services.RoleService;

@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Roles roles = new Roles();
		model.addAttribute("Roles", roles);
		
		return "add-role";
	}
	
	@PostMapping("/addRole")
	public String addRole(@RequestParam("name") String name) {
		
		Roles roles = new Roles(name);
		roleService.addRole(roles);
		
		return "redirect:/home";
				
	}
}
