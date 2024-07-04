package com.bookStore.service;

import com.bookStore.entity.Complaint;
import com.bookStore.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint saveComplaint(Complaint complaint) {
        complaint.setDate(LocalDate.now());
        return complaintRepository.save(complaint);
    }
}
