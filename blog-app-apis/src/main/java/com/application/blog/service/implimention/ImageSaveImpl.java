package com.application.blog.service.implimention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.entities.ImageSave;
import com.application.blog.repositories.ImageSaveRepo;
import com.application.blog.responce_payloads_Dto.PostDto;
@Service
public class ImageSaveImpl {
	@Autowired
	private ImageSaveRepo imageSaveRepo;
	
	public ImageSave create(ImageSave imageSave) {
		
		imageSaveRepo.save(imageSave);
		return imageSave;
	}
}
