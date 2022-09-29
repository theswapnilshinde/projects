package com.microservice.contact.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.contact.entity.Contact;
import com.microservice.contact.service.ContactServiceImpliment;

@CrossOrigin
@RestController
@RequestMapping("api/contact/")
public class contactController {

	@Autowired
	private ContactServiceImpliment contactService;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@PostMapping("/add")
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact)
	{
		 this.contactService.saveContact(contact);
		
		return new ResponseEntity<>(contact,HttpStatus.CREATED);

	}
	
	@GetMapping("/getall")
	public List<Contact> list()
	{
		return contactService.getall();
	}
	
	@GetMapping("/{userId}")
	public Optional<Contact> getUser(@PathVariable ("userId") int userId)
	{
		Optional<Contact> contact = this.contactService.getUser(userId);
		return contact;
		
	}

}
