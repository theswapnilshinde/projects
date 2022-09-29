package com.application.blog.service.implimention;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.entities.Categories;
import com.application.blog.exceptions.ResourceNotFoundException;
import com.application.blog.repositories.CategoriesRepositary;
import com.application.blog.responce_payloads_Dto.CategoriesDto;
import com.application.blog.service.CategaoriesService;
@Service
public class CategorieServiceImpliment implements CategaoriesService{

	@Autowired
	private CategoriesRepositary categoriesRepositary;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoriesDto create(CategoriesDto categoriesDto) {

		Categories categories=this.modelMapper.map(categoriesDto, Categories.class);
		Categories addCategories=this.categoriesRepositary.save(categories);
		return  this.modelMapper.map(addCategories, CategoriesDto.class);
	}

	@Override
	public CategoriesDto update(CategoriesDto categoriesDto, Integer categoryId) {
		System.out.println(categoryId);
		//this.categoriesRepositary.findById(categoryId.toString());

		Categories categories = new Categories();
				this.categoriesRepositary.findById(categoryId);
			//	.orElseThrow(() -> new ResourceNotFoundException("Categoris","categoriesId", categoryId));

		categories.setCategoriesTitle(categoriesDto.getCategoriesTitle());
		categories.setCategoriesDescription(categoriesDto.getCategoriesDescription());

		Categories categoriessave=this.categoriesRepositary.save(categories);
		return  this.modelMapper.map(categoriessave, CategoriesDto.class);
	}

	@Override
	public void delete(Integer categoriesId) {

	Categories  categories =this.categoriesRepositary.findById(categoriesId)
		.orElseThrow(() -> new ResourceNotFoundException("Categoris","categoriesId", categoriesId));

				this.categoriesRepositary.delete(categories);
	}

	@Override
	public CategoriesDto getCategary(Integer categoryId) {

		Categories categories = this.categoriesRepositary.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoris","categoriesId", categoryId));
		return this.modelMapper.map(categories, CategoriesDto.class);
	}



	@Override
	public List<CategoriesDto> getAllCategories() {

		List<Categories> categories= this.categoriesRepositary.findAll();

		List<CategoriesDto> categoriesDtos= categories.stream().map(catDto ->this.categoriesToCategoriesDto(catDto)).collect(Collectors.toList());
		return categoriesDtos;

	}

	public Categories dtoToCategories( CategoriesDto categoriesDto)
	{
		Categories cate = this.modelMapper.map(categoriesDto,Categories.class);
		return cate;

	}

	public CategoriesDto categoriesToCategoriesDto( Categories categories)
	{

		CategoriesDto cateDto = this.modelMapper.map(categories, CategoriesDto.class);

		return cateDto;

	}

}
