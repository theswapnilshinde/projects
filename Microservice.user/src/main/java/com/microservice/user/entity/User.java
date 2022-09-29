package com.microservice.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_microservice")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	//public int id;
	public int userId;
	
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String name;
	
	@NotEmpty
	@Size(min =4,message = "email is mandatory not valid")
	private String email;
	
	
	@NotEmpty	
	@Size(min = 4,message = "password is mandatory")

	private String password;
	
	@NotEmpty
	@Size(min = 4,message = "about is mandatory")
	private String about;

	public User(int userId, @NotEmpty @Size(min = 4, message = "Name is mandatory") String name,
			@NotEmpty @Size(min = 4, message = "email is mandatory not valid") String email,
			@NotEmpty @Size(min = 4, message = "password is mandatory") String password,
			@NotEmpty @Size(min = 4, message = "about is mandatory") String about) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	
	
	
	/*
	 * List<Contact> list = new ArrayList<>();
	 * 
	 * public User(int userId, @NotEmpty @Size(min = 4, message =
	 * "Name is mandatory") String name,
	 * 
	 * @NotEmpty @Size(min = 4, message = "email is mandatory not valid") String
	 * email,
	 * 
	 * @NotEmpty @Size(min = 4, message = "password is mandatory") String password,
	 * 
	 * @NotEmpty @Size(min = 4, message = "about is mandatory") String about,
	 * List<Contact> list) { super(); this.userId = userId; this.name = name;
	 * this.email = email; this.password = password; this.about = about; this.list =
	 * list; }
	 */
	
	
}

