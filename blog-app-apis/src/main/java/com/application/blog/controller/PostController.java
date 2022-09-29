package com.application.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.responce_payloads_Dto.ApiResponce;
import com.application.blog.responce_payloads_Dto.PostDto;
import com.application.blog.service.PostService;


@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createUser(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId)
	{
		PostDto postDto2 = this.postService.createPost(postDto,userId,categoryId);
		return new ResponseEntity<>(postDto2,HttpStatus.CREATED);

	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto> >getPostByUser(@PathVariable Integer userId)
	{
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return  new ResponseEntity< >(posts,HttpStatus.OK);

	}


	@GetMapping("/users/{categoriesId}")
	public ResponseEntity<List<PostDto> > getPostCtegory(@PathVariable Integer categoriesId)
	{
		List<PostDto> posts= this.postService.getPostByCategories(categoriesId);
		return  new ResponseEntity< >(posts,HttpStatus.OK);


	}

	@GetMapping(value = "/getall")
	public ResponseEntity<List<PostDto>> getAllPost(
			@RequestParam(value = "pageNumber"
			//,defaultValue = "1",
			,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "2",required = false) Integer pageSize ){

		List<PostDto> list = this.postService.getAllPost(pageNumber,pageSize);

		return new ResponseEntity<>(list,HttpStatus.OK);

	}

	@GetMapping("/{postId}")
	public ResponseEntity<PostDto>  getPostByid(@PathVariable Integer postId)
	{
		PostDto postDto = this.postService.getPostByIb(postId);
		return  new ResponseEntity<> (postDto,HttpStatus.OK);
	}
	@DeleteMapping("/post/{postId}")
	public ApiResponce deletePost( @PathVariable Integer postId)
	{
	    this.postService.deletePost(postId);
		return new ApiResponce("Post is Successfully Deleted",true);
		
	}

	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> upadatePost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		
		PostDto postDto2 = this.postService.updatePost( postDto, postId);
	    
		return new ResponseEntity<PostDto>(postDto2,HttpStatus.CREATED);
		
	}

}
