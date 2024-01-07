package springMvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("This is home url");
		model.addAttribute("name", "Praveen Chauhan");
		model.addAttribute("id", 107);

		List<String> friends = new ArrayList<String>();
		friends.add("Praveen");
		friends.add("Ankit");
		friends.add("Anuj");
		friends.add("Pankaj");
		friends.add("Himanshi");
		model.addAttribute("f", friends);

		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		System.out.println("This is about page :");

		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("This is help page:");
		//Creating model and view  object
		ModelAndView mv=new ModelAndView();
		//setting the data
		mv.addObject("name", "Praveen Chauhan");
		mv.addObject("id", 107);
		LocalDateTime now= LocalDateTime.now();
		mv.addObject("time",now);
		
		//marks
		List<Integer> li=new ArrayList<Integer>();
		li.add(89);
		li.add(78);
		li.add(90);
		li.add(98);
		li.add(96);mv.addObject("marks",li);
		
		
		
		now.toString();
		//setting the view
		mv.setViewName("help");
		return mv;
	}
}
