package com.bookStore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity

public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String complaint;
    private LocalDate date;

   /* public Complaint(String name, String email, String complaint, LocalDate date) {
        this.name = name;
        this.email = email;
        this.complaint = complaint;
        this.date = date;
    }

    public Complaint() {
    }*/

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

