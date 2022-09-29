package com.example.Project1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
