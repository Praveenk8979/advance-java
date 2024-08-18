package com.meda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("login")
	public String showLoginPage() {
		System.out.println("This is login controller");
		return "login";
	}
	@GetMapping("/")
	public String defaul() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
}
