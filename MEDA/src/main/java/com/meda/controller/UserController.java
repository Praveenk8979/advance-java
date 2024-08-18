package com.meda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.meda.entity.Users;
import com.meda.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private  UserService userService;
	
	@GetMapping("current-user")
	public String currentUser(Model model) {
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Users byUsername=this.userService.getByUsername(username);
		model.addAttribute("users", byUsername);
		return "currentUser";
	}

	@PostMapping("update-current-user")
	public String updateUser(@ModelAttribute("users") Users users, RedirectAttributes redirectAttributes) {
		String message=userService.updateCurrentUser(users);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/user/current-user";
	}
}
