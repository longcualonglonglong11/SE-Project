package com.myclass.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.myclass.dto.LoginDto;
import com.myclass.service.UserInformationService;

@Service
public class UserInformationServiceImpl implements UserInformationService {
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public LoginDto getUserInformation() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal.toString().equals("anonymousUser"))
			return null;
		return (LoginDto) principal;
	}

	@Override
	public int getId() {
		LoginDto dto = getUserInformation();
		if (dto != null)
			return dto.getId();
		return 0;
	}
	

}
