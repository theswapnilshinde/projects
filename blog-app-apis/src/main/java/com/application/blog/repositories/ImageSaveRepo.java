package com.application.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entities.ImageSave;
@Repository
public interface ImageSaveRepo extends JpaRepository<ImageSave, Integer> {

}
