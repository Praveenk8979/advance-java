package com.meda.config;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.meda.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthentication extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		initSession(session, authentication.getName());
		
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	private void initSession(HttpSession session, String department) {
		session.setAttribute("department", department);
		
		List<String> list=List.of("IT Department","Sales Department","Hr Department","Finance Department");
		session.setAttribute("deptList", list);

		
	}
	


	
}
