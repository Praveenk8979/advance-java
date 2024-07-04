package com.bookStore.controller;

import com.bookStore.entity.Complaint;

import com.bookStore.repository.ComplaintRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @GetMapping("/complaint_box")
    public String showComplaintBox(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "complaint_box";
    }

    @PostMapping("/complaint_box")

    public String submitComplaint(Complaint complaint, Model model) {
        complaintRepository.save(complaint);
//        model.addAttribute("message", "Your complaint was successfully submitted.");
        model.addAttribute("complaint", new Complaint()); // reset the form
        return "complaint_box";
    }
}

