package com.greatlearning.EmployeeManagement.services;

import java.util.List;

import com.greatlearning.EmployeeManagement.entities.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public void save(Employee employee);
	
	public Employee findById(int id);
	
	public void deleteById(int id);
	
	public List<Employee> searchBy(String firstName);
	
	public List<Employee> sortBy(List<Employee> employees);
}
