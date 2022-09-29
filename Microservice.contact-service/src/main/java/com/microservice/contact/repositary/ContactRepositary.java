package com.microservice.contact.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.contact.entity.Contact;

@Repository
public interface ContactRepositary extends JpaRepository<Contact,Integer> {

}
