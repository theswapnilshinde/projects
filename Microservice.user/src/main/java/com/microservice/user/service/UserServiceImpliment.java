package com.microservice.user.service;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.Dtos.UserDto;
import com.microservice.user.entity.User;
import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.repositatory.UserRepositatry;

@Service
public class UserServiceImpliment implements UserServiceInterface {

	@Autowired
	private UserRepositatry userRepositary;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	private final String USER_NOT_FOUND_EXCEPTION = "user not found exception";

	@Override
	public UserDto createUser(UserDto userDto) {
		
	
		User user= this.dtoToUser(userDto);
		//UserDto dto = new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getAbout());
		User saveUser=this.userRepositary.save(user);

		return this.userToUserDto(saveUser);
	}
    // modelmapper laibary 
	@Override
	public UserDto updateUser(UserDto userDto, Integer userid) {
		User user = this.userRepositary.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User","id",userid));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());

		User updateUser  =this.userRepositary.save(user);
		UserDto userDto1= this.userToUserDto(updateUser);

		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepositary.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users= this.userRepositary.findAll();
		
		  List<UserDto> userDto= users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
	    //List<UserDto> userDto= users.stream().map(user-> this.userToUserDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userid) {
	
		User user=this.userRepositary.findById(userid).orElseThrow(()->new  ResourceNotFoundException("User","id",userid));
         this.userRepositary.delete(user);
	}
	
	
	public User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto,User.class);
		//User user = new User();
		/*
		 * //user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setAbout(userDto.getAbout());
		 * user.setPassword(userDto.getPassword());
		 */

		return user;

	}

	public UserDto userToUserDto(User user)
	{

		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		/*
		 * 
		   UserDto userDto = new UserDto();   
		 * //userDto.setId(user.getId()); userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); userDto.setAbout(user.getAbout());
		 * userDto.setPassword(user.getPassword());
		 */
		return userDto;

	}
  
	@Override
	public User login(UserDto userDto) {
		
		User user = userRepositary.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		//System.out.println(userRepositary.findById(user.getEmail()));
		if(user.getEmail().equals(userDto.getEmail()) && user.getPassword().equals(userDto.getPassword()));
		{
			return user;
		}
		
	
	/*
	@Override
	public UserDto login(UserDto userDto) {
		
		User user = userRepositary.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		if(user.getEmail().equals(userDto.getEmail()) && user.getPassword().equals(userDto.getPassword()));
		{
			return userDto;
		}
		*/
		
		
	}


}
