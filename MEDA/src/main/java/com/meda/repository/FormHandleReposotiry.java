package com.meda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meda.entity.FormHandle;

@Repository
public interface FormHandleReposotiry extends JpaRepository<FormHandle, Integer> {

}
