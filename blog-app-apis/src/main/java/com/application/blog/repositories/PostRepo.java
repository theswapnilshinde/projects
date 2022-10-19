package com.application.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	//List<Post> findByTitalContainig( String tital);


	// case-in-sensitive searching
//	@Query("select p from Post p where lower(p.title) like concat('%', :keyword,'%')")
	//List<Post> searchPostHavingKeyword(@Param("keyword") String keyword);
	@Query("select p from Post p where p.tital like :keyword")
	List<Post> serchByTital(@Param("keyword") String tital);

}
