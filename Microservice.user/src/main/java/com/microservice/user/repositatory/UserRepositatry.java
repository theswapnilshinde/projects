package com.microservice.user.repositatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.entity.User;

public interface UserRepositatry extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

}
