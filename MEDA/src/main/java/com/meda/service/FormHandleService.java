package com.meda.service;

import java.util.List;
import java.util.Optional;

import com.meda.entity.FormHandle;


public interface FormHandleService {
	
	FormHandle save(FormHandle formHandle);

	Optional<FormHandle> findById(int sno);

	List<FormHandle> findAll();

	void deleteById(int sno);

}
