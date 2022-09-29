package com.application.blog.service;

import java.util.List;

import com.application.blog.entities.User;
import com.application.blog.responce_payloads_Dto.UserDto;


public interface UserService {

	UserDto createUser (UserDto dto);
	UserDto updateUser (UserDto dto,Integer userid);
	UserDto getUserById (Integer userId);
	List <UserDto> getAllUser();
	void deleteUser(Integer userid);
	User login (UserDto userDto);
	//UserDto login (UserDto userDto);
}
