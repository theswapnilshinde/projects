package com.example.Project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project1.Dao.EmplyeeDao;
import com.example.Project1.entity.Employee;

@CrossOrigin
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmplyeeDao dao;
	
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
