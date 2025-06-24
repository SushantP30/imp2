package com.shop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.shop.entity.ImageFile;
import com.shop.service.ImageFileService;

@RestController
@RequestMapping("/image")
public class ImageFileController {

	@Autowired
	private ImageFileService imageFileService;

	@PostMapping("/upload-image")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
		ImageFile savedImage = imageFileService.saveImage(file);
		return ResponseEntity.ok("Image uploaded successfully with ID: " + savedImage.getId());
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id){
		ImageFile imageFile=imageFileService.getImageById(id);
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageFile.getFileType()))
                .body(imageFile.getData());
	}
}
