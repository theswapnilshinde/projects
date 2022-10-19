package com.application.blog.service.implimention;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.application.blog.entities.Categories;
import com.application.blog.entities.Post;
import com.application.blog.entities.User;
import com.application.blog.exceptions.ResourceNotFoundException;
import com.application.blog.repositories.CategoriesRepositary;
import com.application.blog.repositories.PostRepo;
import com.application.blog.repositories.UserRepositary;
import com.application.blog.responce_payloads_Dto.AllPostResponce;
import com.application.blog.responce_payloads_Dto.PostDto;
import com.application.blog.service.PostService;



@Service
public class PostServiceImpl implements PostService{

	private static final long userId = 0;

	@Autowired
	PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepositary userRepositary;

	@Autowired
	private CategoriesRepositary categoriesRepositary;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepositary.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));

		Categories  categories =this.categoriesRepositary.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoris","categoriesId", categoryId));

		Post post	=this.modelMapper.map(postDto, Post.class);
		post.setImageName("tim.png");
		post.setUser(user);
		post.setAddDate(new Date());
		post.setCategories(categories);
		Post updatepost = this.postRepo.save(post);
		return this.modelMapper.map(updatepost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() ->  new ResourceNotFoundException("Post", "id", postId));
		post.setTital(postDto.getTitle());
		post.setContent(postDto.getContent());
		Post post1= this.postRepo.save(post);
		return this.modelMapper.map(post1, PostDto.class);
	}


	@Override
	public void deletePost(Integer postId) {

		Post post = this.postRepo.findById(postId).orElseThrow(() ->  new ResourceNotFoundException("Post", "id", postId));
		this.postRepo.delete(post);
	}

	@Override
	public AllPostResponce getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir) {

		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc"))
		{
			sort=Sort.by(sortBy).ascending();
		}
		else {
			sort =Sort.by(sortBy).descending();
		}
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);

		Page<Post> pagePost = this.postRepo.findAll(p);

		List<Post> allPost =	pagePost.getContent();

		List <PostDto> postDto = allPost.stream().map((post) ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		AllPostResponce postResponce = new AllPostResponce();


		postResponce.setContent(postDto);
		postResponce.setPageNumber(pagePost.getNumber());
		postResponce.setPageSize(pagePost.getSize());
		postResponce.setTotalElement(pagePost.getTotalElements());
		postResponce.setTotalPage(pagePost.getTotalPages());
		postResponce.setLastPage(pagePost.isLast());


		return postResponce;
	}

	@Override
	public PostDto getPostByIb(Integer postId) {
		Post post =this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategories(Integer categoriesId) {

		Categories  cat =this.categoriesRepositary.findById(categoriesId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoris","categoriesId",  categoriesId));

		//List<Post> posts = this.postRepo.findByCategories(cat);  //findByCategories(categories);

		System.out.println("*******"+cat.getCategoriesId()+cat.getCategoriesDescription()+"******");

		//Optional<Post> posts = this.postRepo.findById(cat.categoriesId);
		List<Post> posts = this.postRepo.findByCategoriesCategoriesId(categoriesId);

		List<PostDto> postlist=	posts.stream().map(post-> this.modelMapper.map(post,PostDto.class )).collect(Collectors.toList());
		return postlist ;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user = this.userRepositary.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		List<Post> posts = this.postRepo.findByUser(user);

		List<PostDto> postlist=	posts.stream().map(post-> this.modelMapper.map(post,PostDto.class )).collect(Collectors.toList());


		return postlist;
	}

	@Override
	public List<PostDto> serchPosts(String keyword) {
	List<Post>allPost =	this.postRepo.serchByTital("%"+keyword+"%");

	List <PostDto> postDto = allPost.stream().map((post) ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		return postDto;
	}

	public Post dtoToUser(PostDto postDto)
	{
		Post post = this.modelMapper.map(postDto,Post.class);
		return post;

	}

	public PostDto userToUserDto(Post post)
	{
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;

	}





}
