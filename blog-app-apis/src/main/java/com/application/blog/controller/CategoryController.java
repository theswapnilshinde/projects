package com.application.blog.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.responce_payloads_Dto.ApiResponce;
import com.application.blog.responce_payloads_Dto.CategoriesDto;
import com.application.blog.service.CategaoriesService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController{


	@Autowired
	private CategaoriesService categaoriesService;


	//post create user
	@PostMapping("/add")
	public ResponseEntity<CategoriesDto> createUser(@Valid @RequestBody CategoriesDto categoriesDto)
	{
		CategoriesDto  categoriesDto2= this.categaoriesService.create(categoriesDto);

		return new ResponseEntity<>(categoriesDto,HttpStatus.CREATED);

	}
	//pathuri varible
	@PutMapping("/{categoriesId}")
	public ResponseEntity<CategoriesDto> updateUser(@Valid @RequestBody CategoriesDto categoriesDto ,@PathVariable("categoriesId") Integer categoriesId)
	{
		CategoriesDto CategoriesDto=	this.categaoriesService.update(categoriesDto, categoriesId);
		return ResponseEntity.ok(categoriesDto);

	}

	@DeleteMapping("/{categoriesId}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("categoriesId") Integer categoriesId)
	{
		this.categaoriesService.delete(categoriesId);
		return new ResponseEntity<>(new ApiResponce("User Deleted Succesfully",true), HttpStatus.OK);

	}


	@GetMapping("/{categoriesId}")
	public ResponseEntity<CategoriesDto> getSingleUser(@PathVariable("categoriesId") int categoriesId)
	{

		CategoriesDto categoriesDto = this.categaoriesService.getCategary(categoriesId);
		return new  ResponseEntity<> (categoriesDto, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<CategoriesDto>> getAllList(){

		return ResponseEntity.ok(this.categaoriesService.getAllCategories());

	}

}
