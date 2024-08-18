package com.meda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fileUpload")
public class UploadFile {
	
	@GetMapping("fileUpload")
	public String uploadFile() {
		return "uploadFile";
	}
	
	
	
	

	
	
	


}
