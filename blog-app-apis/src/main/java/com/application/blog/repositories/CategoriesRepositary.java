package com.application.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entities.Categories;
@Repository
public interface CategoriesRepositary extends JpaRepository<Categories, Integer> {


}
