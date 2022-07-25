package com.epam.authservicejwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.epam.authservicejwt.model.LoginEntity;

@Service
public class UserService {

	@Autowired
	AuthenticationManager authenticationManager;

	public void validate(LoginEntity loginentity) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginentity.getUsername(), loginentity.getPassword()));
	}

}
