package com.example.shopping.controller;

import com.example.shopping.dto.ResponseDto;
import com.example.shopping.dto.user.SignInDto;
import com.example.shopping.dto.user.SignInReponseDto;
import com.example.shopping.dto.user.SignupDto;
import com.example.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    // two apis

    // signup

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto)  {
    	System.out.println("signup");
        return userService.signUp(signupDto);
        
     
    }


    // signin

    @PostMapping("/signin")
    public ResponseDto signIn(@RequestBody SignInDto signInDto) throws Exception {
        return userService.signIn(signInDto);
    }


}
