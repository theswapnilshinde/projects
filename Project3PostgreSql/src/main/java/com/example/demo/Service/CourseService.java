package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repositary.CourseRepository;
import com.example.demo.entity.Course;


@Service
public class CourseService implements CourseServiceIn {

	
	@Autowired
	CourseRepository repo;
	public void addCourse(Course course) {
		course= new Course(course.getId(),course.getName(),course.getFees());
		repo.save(course);
	}


	public List<Course> listCourse() {
	//.	repo.findAll();
		
		return repo.findAll();
	}

	@Override
	public String editCourse( Course course) {
		repo.save(course);
		return "Udate Course";
	}
	
	@Override
	public String deleteCourse(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Course Deleted";
	}


	@Override
	public String add(Course course) {
		// TODO Auto-generated method stub
		return null;
	}


	public Optional<Course> findidCourse(int id) {
		// TODO Auto-generated method stub
		//return null;
		return  repo.findById(id);
	}


	

	

}
