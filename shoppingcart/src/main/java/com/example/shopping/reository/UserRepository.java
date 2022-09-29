package com.example.shopping.reository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	 

}
