package com.example.demo.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
