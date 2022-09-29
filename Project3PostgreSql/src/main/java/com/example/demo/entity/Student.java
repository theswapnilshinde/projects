package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="studentid")
	public int studentId;

	@Column(name="studentname")
	public String studentName;

	@Column(name="course")
	public String coursename;

	@Column(name="email")
	public String email;

	@Column(name="password")
	public String password;
	
	@Embedded
	private Certificate certi;


	public Certificate getCerti() {
		return certi;
	}

	public Student(int studentId, String studentName, String coursename, String email, String password,
			Certificate certi) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.coursename = coursename;
		this.email = email;
		this.password = password;
		this.certi = certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public Student() {

	}

	public Student(int studentId, String studentName, String coursename, String email, String password) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.coursename = coursename;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", coursename=" + coursename
				+ ", email=" + email + ", password=" + password + "]";
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





}
