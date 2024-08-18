package com.meda.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class CSVTemplateController {
	
	@GetMapping("/csvTemplate_upload")
	public void downloadTemplate(HttpServletResponse response) throws Exception{
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"template.csv\"");
		
		String[] headers={"Sno", "FileId","VolumeNo","BookNo","PageFrom","PageTo","DateOfRegistration"
				,"DocumentType","RegistrationDistrict"};
		
		try (PrintWriter writer=response.getWriter()){
			for(String header : headers ) {
				writer.print(header);
				writer.print(",");
			}
			writer.print("\n");
		}
	}
	

}
