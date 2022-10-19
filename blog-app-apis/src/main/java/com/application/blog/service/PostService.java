package com.application.blog.service;

import java.util.List;

import com.application.blog.responce_payloads_Dto.AllPostResponce;
import com.application.blog.responce_payloads_Dto.PostDto;

public interface PostService {


	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	PostDto updatePost(PostDto postDto,Integer  postId);

	void deletePost(Integer postId);

	//List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	AllPostResponce  getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

	PostDto getPostByIb(Integer postId);

	//get all posts by category
	List<PostDto> getPostByCategories(Integer   categoriesId);

	//get all posts by user
	List<PostDto> getPostByUser(Integer userId);

	//get all posts by user
	List<PostDto> serchPosts(String keyword);

}
