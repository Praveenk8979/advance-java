package springMvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springMvc.model.User;
import springMvc.service.UserService;
@Controller
public class ContactController {
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header","LearnCodeWithPraveen");
		m.addAttribute("Desc"," Home for Programmer" );
		System.out.println("Adding the data ");
	}
	
	@RequestMapping("/contact")
	public String showForm(Model m) {
		
		return "contact";
	}
	
	@RequestMapping(path="/processform",method=RequestMethod.POST)
//	public String handleFrom(HttpServletRequest request) {
//		 String email=request.getParameter("email");
//		 String name=request.getParameter("username");
//		 String password=request.getParameter("userpassword");
//		 System.out.println("User name is :"+name);
//		 		System.out.println("User email is :"+email);
//		 		System.out.println("Password is :"+password);
//				 
	public String handleFrom(@ModelAttribute User user , Model model) {
		
		System.out.println(user);
		
		if(user.getUserName().isBlank()) {
			return "redirect:/contact";
		}
		
		int createUser = this.userService.createUser(user);
		model.addAttribute("msg", "User created with id"+createUser);
		return "success";
	}

}

/*

public String handleFrom(
		@RequestParam("username") String name,
		@RequestParam("email") String email,
		@RequestParam("userpassword") String password , Model model) {
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		System.out.println(user);
		
		System.out.println("User name is:"+name);
		System.out.println("User email is :"+email);
		System.out.println("User password is:"+password);
		
		//process
		
//		model.addAttribute("name",name);
//		model.addAttribute("email",email);
//		model.addAttribute("password",password);
		model.addAttribute("user",user);
		return "success";
	}

}
*/
