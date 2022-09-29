package com.application.blog.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="postid")
    private int postId;

//	@Column(name="title",length = 100 , nullable = false)
//	@NotEmpty
//	@Size(min =4,message = "tital is mandatory")
	private String tital;

//	@Column(name="content",length = 10000 , nullable = false)
//	@NotEmpty
//	@Size(min =4,message = "content is mandatory")
	private String content;

//	@Column(name="imagename",length = 100 , nullable = false)
//	@NotEmpty
//	@Size(min =4,message = "imagename is mandatory")
	private String imageName;


//	@Column(name="addDate",length = 100 , nullable = false)
//	@NotEmpty
//	@Size(min =2,message = "Date is mandatory")
	private Date addDate;


	// @JsonManagedReference
	@ManyToOne
//	@JoinColumn(name = "categories")
	private Categories categories;


	// @JsonManagedReference
	@ManyToOne
	private User user;


}
