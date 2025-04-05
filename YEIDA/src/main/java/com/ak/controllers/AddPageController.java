package com.ak.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.GenerationType;

import org.hibernate.annotations.GenerationTime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddPageController {
	
	@RequestMapping(value = "/addPage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPage(
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pdfFile") MultipartFile pdfFile) {

        Map<String, Object> response = new HashMap<>();

        try {
            // Validate inputs
            if (pageNumber <= 0) {
                response.put("success", false);
                response.put("message", "Invalid page number.");
                return response;
            }
            if (pdfFile.isEmpty()) {
                response.put("success", false);
                response.put("message", "No PDF file uploaded.");
                return response;
            }

            // Process the PDF file (e.g., save it or manipulate it)
            // For now, we'll just print the file name and page number
            System.out.println("Page Number: " + pageNumber);
            System.out.println("PDF File Name: " + pdfFile.getOriginalFilename());

            // Return success response
            response.put("success", true);
            response.put("message", "Page added successfully!");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to add page: " + e.getMessage());
        }

        return response;
    }

}
