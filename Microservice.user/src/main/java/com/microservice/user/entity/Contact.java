package com.microservice.user.entity;

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


public class Contact {
	
	
	public int contactId;
	
	
	private String name;
	
	
	private String email;
	
	
	private int userId;



	/*
	 * public Contact(int contactId, @NotEmpty @Size(min = 4, message =
	 * "Name is mandatory") String name,
	 * 
	 * @NotEmpty @Size(min = 4, message = "email is mandatory not valid") String
	 * email,
	 * 
	 * @NotEmpty @Size(min = 4, message = "email is mandatory not valid") int
	 * userId) { super(); this.contactId = contactId; this.name = name; this.email =
	 * email; this.userId = userId; }
	 */
	/*
	@NotEmpty	
	@Size(min = 4,message = "password is mandatory")

	private String password;
	
	@NotEmpty
	@Size(min = 4,message = "about is mandatory")
	private String about;
	*/
	
}
