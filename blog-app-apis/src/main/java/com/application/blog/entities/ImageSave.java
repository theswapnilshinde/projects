package com.application.blog.entities;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="imagesave")
@Data
public class ImageSave {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="postid")
    private int postId;

//	@Column(name="title",length = 100 , nullable = false)
//	@NotEmpty
//	@Size(min =4,message = "tital is mandatory")
	private String name;
	@Lob
	private Blob image;
	
	
}
