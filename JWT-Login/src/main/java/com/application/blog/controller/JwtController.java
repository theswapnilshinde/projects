package com.application.blog.controller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.helper.JwtUtil;
import com.application.blog.model.JWTRequest;
import com.application.blog.model.JWTResponce;
import com.application.blog.service.CustomUserDetails;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetails customUserDetails;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/token",method= RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception
	{
	System.out.println(jwtRequest);
	//return jwtRequest;
	
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.username, jwtRequest.password));
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		
		UserDetails userDetails = this.customUserDetails.loadUserByUsername(jwtRequest.getUsername());
       String token = this.jwtUtil.generateToken(userDetails);
       
       System.out.println("JWT"+ token);
       
       return ResponseEntity.ok(new JWTResponce(token));
	}
	

	

}
