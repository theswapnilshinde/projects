package com.example.demo.Service;

import com.example.demo.entity.Course;

import antlr.collections.List;

public interface CourseServiceIn {
	
	//	public List listCourse();

	String editCourse(Course course);
	//String deleteCourse(int i); not working
	String add(Course course);

	String deleteCourse(int id);

}
