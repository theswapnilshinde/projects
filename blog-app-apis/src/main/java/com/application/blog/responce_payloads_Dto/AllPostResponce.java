package com.application.blog.responce_payloads_Dto;

import java.util.List;

import lombok.Data;

@Data
public class AllPostResponce {
	
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize ;
	private long totalElement;
	private int totalPage;
	private Boolean lastPage;

}
