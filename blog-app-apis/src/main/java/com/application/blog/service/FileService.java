package com.application.blog.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String uplodImage(String path, MultipartFile file ) throws IOException;
    InputStream getResorce(String path, String fileName ) throws FileNotFoundException;

}
