package com.microservice.user.service;

import java.util.List;

import com.microservice.user.Dtos.UserDto;
import com.microservice.user.entity.User;



public interface UserServiceInterface {
	
	UserDto createUser (UserDto dto);
	UserDto updateUser (UserDto dto,Integer userid);
	UserDto getUserById (Integer userId);
	List <UserDto> getAllUser();
	void deleteUser(Integer userid);
	User login (UserDto userDto);
	//UserDto login (UserDto userDto);

}
