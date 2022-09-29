package com.application.blog.service;

import java.util.List;

import com.application.blog.responce_payloads_Dto.CategoriesDto;

public interface CategaoriesService {

	 CategoriesDto  create(CategoriesDto categoriesDto);
	 CategoriesDto  update(CategoriesDto categoriesDto,Integer categoryId);
	 void delete( Integer categoryId);
	 CategoriesDto  getCategary(Integer  categoriesId);

	 List<CategoriesDto> getAllCategories();


}
