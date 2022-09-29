package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.StudentDto;
import com.example.demo.Service.StudentService;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.ResorceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.addCourse(student);
		return "student Added in db";
		
	}
	
	@GetMapping("/get")
	public List<Student>  showAll()
	{
		return studentService.listCourse();
		
	}
	
	@PutMapping("/put")
	public String update(@RequestBody Student student )
	{
		studentService.editCourse(student);
		return "student Updated";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Student deleteCourse(@PathVariable ("id") int id)
	{
		return ((Student) this.studentService.deleteStudent(id));
		 
		
	}
	/*
	 * @PutMapping("/showAll") public List<Course> shoall() { return
	 * courseService.showall();
	 * 
	 * }
	 */
	@PutMapping("/find/{id}")
	public Student findByIdCourse(@PathVariable("id") int id) {
		return this.studentService.findidStudent(id).orElseThrow(() -> new ResorceNotFoundException ("UserNotFound with id :" + id));
		
	}
	
	@PutMapping("/finde/{id}")
	public Student findByIddelite(@PathVariable("id") int id) {
		return this.studentService.deleteStudent(id);
	}
	
	@PostMapping("/login")
	public Student login(@RequestBody StudentDto dto)
	{
		return studentService.login(dto);
		
	}
	
	/*
	  @PostMapping("validate") //@ApiOpration(value="") public ResponseEntity<?>
	  validateUse(@RequestBody Student student) { //System.out.println(student);s
	  student = studentService.validate(student); if(student !=null) { return new
	  ResponseEntity<Student>(student,HttpStatus.OK); } else { return new
	  ResponseEntity<String>("Invalid Email OR Passwor",HttpStatus.ACCEPTED); }
	  }
	  */
	@PostMapping("/new")
	public Student addnewStudents(@RequestBody StudentDto studentDto)
	{
		return studentService.addNewStudent(studentDto);
		
		
	}
}
