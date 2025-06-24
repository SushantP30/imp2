package com.shop.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.ImageFile;

public interface ImageFileService {
	 public ImageFile saveImage(MultipartFile file) throws IOException;
	  public ImageFile getImageById(Long id);
}
