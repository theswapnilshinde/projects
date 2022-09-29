package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.StudentDto;
import com.example.demo.Repositary.StudentRepositary;
import com.example.demo.entity.Student;

@Service
public class StudentService implements StudentServiceInterface {

	
	@Autowired
	StudentRepositary repo;
	
	public void addCourse(Student student) {
		student = new Student(student.studentId,student.getStudentName(),student.getCoursename(),student.getEmail(),student.getPassword());
		repo.save(student);
	}

	public List<Student> listCourse() {
		return repo.findAll();
	}

	public void editCourse(Student student) {
		repo.save(student);
	}

	public Student deleteStudent(int id) {
		repo.deleteById(id);
		return null;
		
	}
	public Optional<Student> findidStudent(int id) {
		return repo.findById(id);
	}

	@Override
	public Student addNewStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
		Student student = new Student(studentDto.studentId,studentDto.studentName,studentDto.getCoursename(),studentDto.getEmail(),studentDto.getPassword());
		return repo.save(student);
	}

	@Override
	public Student login(StudentDto studentDto) {
		Student student =repo.findByEmailAndPassword(studentDto.getEmail(), studentDto.getPassword());
		//if(student.getEmail().equals(studentDto.getEmail(),student.getPassword().equals(studentDto.getPassword());
		if(student.getEmail().equals(studentDto.getEmail()) && student.getPassword().equals(studentDto.getPassword()));
		{return student;}
		/*
		 * else return "invalid email Or Password";
		 */
		
			
		
	}
	
	

	/*public Student validate(Student student) {
		Student student2= null;
		try {
			student2= repo.findByStudentEmailAndPassword(student.getEmail(), student.getPassword());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return student2;
	}*/

}
