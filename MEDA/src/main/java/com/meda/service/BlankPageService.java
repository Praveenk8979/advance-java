package com.meda.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface BlankPageService  {
	
	Map<String, String> startBlankPage(String pdfSource);

	
}
