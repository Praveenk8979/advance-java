package com.meda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BulkUploadController {
	
	@GetMapping("uploadCsv1")
	public String uploadCsv()
	{	
		return "uploadCsv1";
	}
}