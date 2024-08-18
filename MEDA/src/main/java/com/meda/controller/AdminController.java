package com.meda.controller;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.meda.entity.Role;
import com.meda.entity.Users;
import com.meda.service.UserService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
	
	@Autowired
	private  UserService userService;
	
	@GetMapping("add-user")
	public String addUserForm(Model model) {
		Users user=new Users();
		user.setRoles(new Role());
		model.addAttribute("users", user);
		return "addUser";
	}

	@PostMapping("add-user")
	public String addUser(@ModelAttribute(name="users") Users users , RedirectAttributes redirectAttributes) {
		String message=userService.saveUser(users);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/admin/add-user";
	}
	

	
	@GetMapping("user-list")
	public String userList(Model model, @RequestParam(name = "username", required = false) String username) {

		Users users = username == null
				? this.userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
				: this.userService.getByUsername(username);

		model.addAttribute("users", users);
		model.addAttribute("userList", userService.getAllUsers());
		return "userList";
	}
	
	  @PostMapping("update-User")
	  public String updateUser(@ModelAttribute("users") Users users, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", userService.updateUser(users));
		return "redirect:/admin/user-list?username=" + users.getUsername();
		}

		@PostMapping("deleteUser")
		public String deleteUser(@RequestParam String deleteUsername, RedirectAttributes redirectAttributes) {
			userService.deleteUser(deleteUsername);
			redirectAttributes.addFlashAttribute("message", "User delete successfully with username : " + deleteUsername);
			return "redirect:/admin/user-list";
		}
}
