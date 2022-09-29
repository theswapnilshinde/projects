package com.example.Second.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Second.Entity.Employee;
import com.example.Second.Repositary.EmployeeRepository;

@Service
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository repo;

	public void saveEmployee(Employee employee) {
		employee = new Employee(employee.getId(),employee.getName(),employee.getAge());
		repo.save(employee);
		
	}
	
	public List<Employee> showAll(){
		return repo.findAll();
		
	}
	
	
	
	

}
