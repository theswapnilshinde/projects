package com.example.shopping.service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.shopping.dto.ResponseDto;
import com.example.shopping.dto.user.SignInDto;
import com.example.shopping.dto.user.SignInReponseDto;
import com.example.shopping.dto.user.SignupDto;
import com.example.shopping.model.User;
import com.example.shopping.reository.UserRepository;
import com.example.shopping.exception.CustomException;




@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public ResponseDto signUp(SignupDto signupDto) {
		   System.out.println("signup success");
		   String email=signupDto.getEmail();
		  
		   if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
	            // we have an user
			   ResponseDto responseDto = new ResponseDto("failed", "user already present");
		        return responseDto;
	            
	        }

	        // hash the password

	        String encryptedpassword = signupDto.getPassword();

	  

	        User user = new User(signupDto.getFirstName(), signupDto.getLastName(),
	                signupDto.getEmail(), encryptedpassword);
	        
	        System.out.println("signup success 1"+signupDto.getFirstName());
	        userRepository.save(user);
	        System.out.println("signup success 2"+user.getFirstName());

	        // save the user

	        // create the token

	        ResponseDto responseDto = new ResponseDto("success", "user created succesfully");
	        return responseDto;
	}

	public ResponseDto signIn(SignInDto signInDto)  {
		// TODO Auto-generated method stub
	User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
        	ResponseDto responseDto = new ResponseDto("failed", "user is not valid");
		    return responseDto;
           
        }

        // hash the password

        if (!user.getPasswoprd().equals(signInDto.getPassword())) {
			ResponseDto responseDto = new ResponseDto("failed", "wrong password");
		    return responseDto;
		}

        // compare the password in DB

        // if password match


        // retrive the token

        ResponseDto responseDto = new ResponseDto("success", "user login succesfully");
        return responseDto;

        // return response
    }
	

}
