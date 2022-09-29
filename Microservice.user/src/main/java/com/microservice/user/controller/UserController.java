package com.microservice.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.Dtos.UserDto;
import com.microservice.user.entity.User;
import com.microservice.user.responce.ApiResponce;
import com.microservice.user.responce.Responce;
import com.microservice.user.service.UserServiceInterface;




@CrossOrigin
@RestController
@RequestMapping("api/users/")
public class UserController {

	@Autowired
	private UserServiceInterface userService;


	//post create user
	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto userDto2= this.userService.createUser(userDto);

		return new ResponseEntity<>(userDto2,HttpStatus.CREATED);

	}
	//pathuri varible
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userid") Integer userid)
	{
		UserDto userDto2=	this.userService.updateUser(userDto, userid);
		return ResponseEntity.ok(userDto2);

	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("userid") Integer userid)
	{
		this.userService.deleteUser(userid);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User Deleted Succesfully",true), HttpStatus.OK);

	}
	@GetMapping("/getall")
	public ResponseEntity<List<UserDto>> allUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUser());
	}

	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("userid") int userid)
	{
		return ResponseEntity.ok(this.userService.getUserById(userid));
		//return ResponseEntity.ok(this.userService.getUserById(userid));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto)
	{
	//	System.out.println(userDto);
		User user =userService.login(userDto);
		
		if(user != null )
			return Responce.success(user);
		else
			return Responce.status(HttpStatus.NOT_FOUND);
	}
	/*
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Customer user=customerService.validate(dto.getEmail(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	*/
	
	
	
	
	
}
