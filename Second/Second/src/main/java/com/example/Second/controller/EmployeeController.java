package com.example.Second.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Second.Dao.EmployeeDao;
import com.example.Second.Entity.Employee;
@CrossOrigin
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@PostMapping("/add")
	public String add(@RequestBody Employee employee)
	{
		dao.saveEmployee(employee);
		return "Added";
		
	}
	@GetMapping("/get")
	public List<Employee> list() {
		return dao.showAll();
		
		
	}

}
