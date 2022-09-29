package com.microservice.user.Dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//@Data
public class UserDto {
	
	 private Long id;
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String name;
	
	@Email(message = "email is mandatory not valid")
	//@Size(min =4,message = "email is mandatory not valid")
	private String email;
	
	
	@NotEmpty	
	@Size(min = 4,message = "password is mandatory")

	private String password;
	
	@NotEmpty
	@Size(min = 4,message = "about is mandatory")
	private String about;
	
	
	/*
    private Long id;
    @NotNull(message = "Name is mandatory")
	private String name;
    @Email(message = "Email is mandatory")
	private String email;
    @NotNull(message = "password is mandatory")
	private String password;
    @NotNull(message = "about is mandatory")
	private String about;
	*/
    /*
	public UserDto (String name, String email, String password, String about) {
		super();
		this.id = id; 
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	@Override
	public String toString() {
		return "UserDto [ name=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + "]";
	}
	*/

}

