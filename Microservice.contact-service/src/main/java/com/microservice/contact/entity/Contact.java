package com.microservice.contact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contact_microservice")

public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id")
	public int contactId;
	
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String name;
	
	@NotEmpty
	@Size(min =4,message = "email is mandatory")
	private String email;

	
	private int userId;

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	

	public Contact(int contactId, @NotEmpty @Size(min = 4, message = "Name is mandatory") String name,
			@NotEmpty @Size(min = 4, message = "email is mandatory") String email, int userId) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.email = email;
		this.userId = userId;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", email=" + email + ", userId=" + userId + "]";
	}

	


	
	
}
