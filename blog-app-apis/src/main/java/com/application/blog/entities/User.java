package com.application.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="user1")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	//public int id;
	public int id;

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

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> posts= new ArrayList<>();

}
