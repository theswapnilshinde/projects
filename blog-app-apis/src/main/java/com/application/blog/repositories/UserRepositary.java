package com.application.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entities.User;
@Repository
public interface UserRepositary  extends JpaRepository<User, Integer>{

	public User findByEmailAndPassword(String email,String password);
}
