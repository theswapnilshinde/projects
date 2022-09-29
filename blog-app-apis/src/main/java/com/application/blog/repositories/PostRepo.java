package com.application.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entities.Categories;
import com.application.blog.entities.Post;
import com.application.blog.entities.User;
@Repository
public interface PostRepo  extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	//List<Post> findByCategories(Categories categories);

	List<Post> findByCategories(Categories categories);
	List<Post> findByCategories(Integer categoriesId);
	List<Post> findByCategoriesCategoriesId(Integer categoriesId);


}
