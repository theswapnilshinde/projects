package com.example.demo.Service;

import com.example.demo.Dto.StudentDto;
import com.example.demo.entity.Student;

public interface StudentServiceInterface {
	public Student addNewStudent(StudentDto studentDto);
	public Student login(StudentDto studentDto);

}
