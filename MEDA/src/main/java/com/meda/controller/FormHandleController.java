package com.meda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.meda.entity.FormHandle;
import com.meda.service.FormHandleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("fileUpload")
@RequiredArgsConstructor
public class FormHandleController {

	@Autowired
	private  FormHandleService formHandleService;

	@GetMapping("/uploadForm/{dept}")
	public String showForm(@PathVariable("dept") String dept, Model model) {
		model.addAttribute("dept", dept);

//		model.addAttribute("formHandle", new FormHandle());

		return "uploadForm";
	}

	@PostMapping("/uploadForm/{dept}")
	public String handleForm(@PathVariable("dept") String dept,
			@ModelAttribute(name = "formHandle") FormHandle formHandle, RedirectAttributes redirectAttributes) {

//		System.out.println("Model value : "+formHandle);
		formHandleService.save(formHandle);
		redirectAttributes.addFlashAttribute("message", dept + " SuccessFully Upload!");
		return "redirect:/fileUpload/uploadForm/" + dept;

	}

}
