package com.greatlearning.EmployeeManagement.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.EmployeeManagement.entities.Employee;
import com.greatlearning.EmployeeManagement.services.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("Employees", employees);
		
		return "list-employees";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("Employee", employee);
		
		return "employee-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		
		Employee employee = employeeService.findById(id);
		model.addAttribute("Employee", employee);
		
		return "employee-form";
	}
	
	@RequestMapping("/sort")
	public String sortEmployee( Model model) {
		
		List<Employee> sorted = employeeService.findAll();
		List<Employee> employees = employeeService.sortBy(sorted);
		model.addAttribute("Empolyees", employees);
		
		return "list-employees";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		
		Employee employee;
		
		if(id != 0) {
			
			employee = employeeService.findById(id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
		}
		
		else {
			employee = new Employee(firstName, lastName, email);
		}
		
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("firstName") String firstName, Model model) {
		
		if(firstName.trim().isEmpty()) {
			return "redirect:/employees/list";
		}
		else {
			List<Employee> employees = employeeService.searchBy(firstName);
			model.addAttribute("Employees", employees);
			
			return "list-employees";
		}
	}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		
		ModelAndView model = new ModelAndView();
		
		if(user != null) {
			model.addObject("msg", "Hi "+user.getName()+" you don't have permission to access this page!");
		}
		else {
			model.addObject("msg", "You don't have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
}
