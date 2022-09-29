package com.example.demo.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
@Repository
public interface StudentRepositary extends JpaRepository<Student, Integer>{
	
  public Student findByEmailAndPassword(String email,String password);

}
