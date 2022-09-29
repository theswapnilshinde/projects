package com.example.Second.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Second.Entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
