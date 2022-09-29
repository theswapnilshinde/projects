package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositary.CourseRepository;
import com.example.demo.Repositary.StudentRepositary;
import com.example.demo.Service.CourseService;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;


@CrossOrigin
@RestController
//@RequestMapping(value = "/course")
@RequestMapping("/course")
public class CourserController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	//StudentRepositary repositary;
	CourseRepository courseRepository;
	/*
	 * @PostMapping("/add") public String add(@RequestBody Course course) {
	 * //courseService.addCourse(course); return "course Added in db";
	 * 
	 * }
	 */
	@PostMapping("/add")
	public Course createcourse(@RequestBody Course course)
	{
		return this.courseRepository.save(course);
	}
	
	@GetMapping("/get")
	public List<Course>  showAll()
	{
		return courseService.listCourse();
		
	}
	
	@PutMapping("/put")
	public String update(@RequestBody Course course)
	{
		courseService.editCourse(course);
		return "Course Updated";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable ("id") int id)
	{
		  courseService.deleteCourse(id);
		  return "Course Deleted";
		
	}
	
	 
	@PutMapping("/find/{id}")
	public Optional<Course> findByIdCourse(@PathVariable("id") int id) {
		return courseService.findidCourse(id);
		
	}
    
	
}
