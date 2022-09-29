package com.application.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin1")
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="studentid")
	private int id;

}
