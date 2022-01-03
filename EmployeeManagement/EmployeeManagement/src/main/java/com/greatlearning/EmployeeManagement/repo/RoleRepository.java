package com.greatlearning.EmployeeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.EmployeeManagement.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
