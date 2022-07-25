package com.epam.libraryservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.epam.libraryservice.entity.LoginEntity;
import com.epam.libraryservice.entity.TokenResponseEntity;


@FeignClient(url="localhost:9091/",name="auth-service")
public interface AuthFeignClient {
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponseEntity> getToken(@RequestBody LoginEntity loginentity);

	@PostMapping("/verify")
	public ResponseEntity<Boolean> verifyToken(@RequestHeader("Authorization") String token);

}