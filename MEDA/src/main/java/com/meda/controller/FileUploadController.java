package com.meda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.meda.service.CSVService;

@Controller
@RequestMapping("/")
public class FileUploadController {

	@Autowired
	private CSVService csvService;
	
	

	@PostMapping("/uploadCsv1")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, @RequestParam("department") String department,
			RedirectAttributes flashAttributes, Model model) {
		String message ;

		if (file.isEmpty()) {
			message = "Please select a CSV file to upload .";

		}
		try {
			csvService.save(file);
			message = "(" + file.getOriginalFilename() + ") File uploaded and data saved successfully .";
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "(" + file.getOriginalFilename() + ") An error occurred while processing the file .";
			
		}

		
		model.addAttribute("message", message);
		
		return "uploadCsv1";
	}
}