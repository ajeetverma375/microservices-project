package com.epam.authservicejwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.epam.authservicejwt.model.LoginEntity;
import com.epam.authservicejwt.model.TokenResponseEntity;
import com.epam.authservicejwt.service.TokenService;
import com.epam.authservicejwt.service.UserService;

@RestController
public class AuthControler {

	@Autowired
	TokenService tokenService;
	@Autowired
	UserService userservice;

	@GetMapping("/data")
	public String data()
	{
		return "data";
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponseEntity> getToken(@RequestBody LoginEntity loginentity) {
		System.out.println("/n/n"+loginentity.toString());
		userservice.validate(loginentity);
		TokenResponseEntity token = new TokenResponseEntity(tokenService.successToken(loginentity.getUsername()));
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@PostMapping("/verify")
	public ResponseEntity<Boolean> verifyToken(@RequestHeader("Authorization") String token) {
		boolean result = tokenService.authentication(token);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}