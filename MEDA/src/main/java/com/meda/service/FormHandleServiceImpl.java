package com.meda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meda.entity.FormHandle;
import com.meda.repository.FormHandleReposotiry;

@Service
public class FormHandleServiceImpl implements FormHandleService {
	
	@Autowired
	private FormHandleReposotiry formHandleReposotiry;

	@Override
	public FormHandle save(FormHandle formHandle) {
		return formHandleReposotiry.save(formHandle);
	}

	@Override
	public Optional<FormHandle> findById(int sno) {
		return formHandleReposotiry.findById(sno);
	}

	@Override
	public List<FormHandle> findAll() {
		return formHandleReposotiry.findAll();
	}

	@Override
	public void deleteById(int sno) {
		formHandleReposotiry.deleteById(sno);
	}

}
