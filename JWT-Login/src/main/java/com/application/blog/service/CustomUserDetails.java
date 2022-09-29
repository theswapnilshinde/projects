package com.application.blog.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetails implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(username.equals("Swapnil"))
		{
			String password;
			return new User(username = "Swapnil",password="Swapnil@123", new ArrayList<>());
			//return User ("swapnil","swapnil",)
		}
		else {
			throw new UsernameNotFoundException(username+"User name Not found");
		}
		
			
		
	}

}
