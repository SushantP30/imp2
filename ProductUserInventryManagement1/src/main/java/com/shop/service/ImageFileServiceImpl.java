package com.shop.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.ImageFile;
import com.shop.repository.ImageFileRepository;

@Service
public class ImageFileServiceImpl implements ImageFileService {

	@Autowired
	private ImageFileRepository imageFileRepository;
	
	//save imageFile in db 
	@Override
	public ImageFile saveImage(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		ImageFile imageFile=new ImageFile();
		imageFile.setFileName(file.getOriginalFilename());
		imageFile.setFileType(file.getContentType());
		imageFile.setData(file.getBytes());
		return imageFileRepository.save(imageFile);
	}

	//get imageFile by id 
	@Override
	public ImageFile getImageById(Long id) {
		
		return imageFileRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Image not found with id: " + id));

	}

}
