package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
}
