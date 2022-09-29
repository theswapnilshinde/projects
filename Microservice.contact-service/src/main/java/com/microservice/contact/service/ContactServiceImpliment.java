package com.microservice.contact.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.contact.entity.Contact;
import com.microservice.contact.repositary.ContactRepositary;


@Service
public class ContactServiceImpliment {
	
	@Autowired
	public ContactRepositary contactRepositary;
	/*
	 * List<Contact> list = List.of( new Contact(49L,"Swapnil",
	 * "swapnil@emil.com",49L), new Contact(51L,"jimm", "jimm@emil.com",51L)
	 * 
	 * );
	 * 
	 * 
	 * @Override public List<Contact> getContactsOfUser(Long userId) {
	 * list.stream().filter(contact ->
	 * contact.getUserId().equals(userId)).collect(Collectors.toList());
	 * 
	 * return null;
	 * 
	 * }
	 


	@Override
	public Contact saveContact(Contact contact) {
		 contact= new Contact(contact.contactId,contact.getName(),contact.getEmail(),contact.getUserId());
	 	contactRepositary.save(contact);
		return contact;

	}
	*/

	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		contact= new Contact(contact.contactId,contact.getName(),contact.getEmail(),contact.getUserId());
	 	contactRepositary.save(contact);
		
	}

	public List<Contact> getall() {
			return contactRepositary.findAll();
	}

	public Optional<Contact> getUser(int userId) {
		
		return contactRepositary.findById(userId);
	}

}
