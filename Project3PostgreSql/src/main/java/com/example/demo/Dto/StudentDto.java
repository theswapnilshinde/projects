package com.example.demo.Dto;

import javax.persistence.Column;

public class StudentDto {

	public int studentId;
	
	public String studentName;

	public String coursename;

	public String email;
	
	public String password;

	public StudentDto(int studentId, String studentName, String coursename, String email, String password) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.coursename = coursename;
		this.email = email;
		this.password = password;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
