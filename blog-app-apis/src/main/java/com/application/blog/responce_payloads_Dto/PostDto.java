package com.application.blog.responce_payloads_Dto;

import java.util.Date;

import lombok.Data;

@Data
public class PostDto {

	private int postId;
	private String tital;

	private String content;

	private String imageName;

    private Date addDate;

	private CategoriesDto categories;

	private UserDto user;

}
