package com.api.book.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.Helper;

@RestController
public class FileUploadController {

	@Autowired
	private Helper helper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

		
		
		//validation
		
		try {
			
		
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contains file");
		}
		
		//
		if(!file.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only png content type are allowed");
		}
		
		//file upload code
		
		boolean f = helper.uploadFile(file);
		if(f) {
//			return ResponseEntity.ok("File is successfully uploaded");
			
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			
			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some went wrong ! Try again");
	}

	
	
}
