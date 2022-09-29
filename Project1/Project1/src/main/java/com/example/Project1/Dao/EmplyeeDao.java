package com.example.Project1.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project1.entity.Employee;
import com.example.Project1.repo.EmployeeRepository;


@Service
public class EmplyeeDao {
	
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
