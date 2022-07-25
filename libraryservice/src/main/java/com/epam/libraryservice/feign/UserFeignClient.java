package com.epam.libraryservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.libraryservice.entity.UserDTO;
import com.epam.libraryservice.entity.UserEntity;

@FeignClient(name="user-service")//,fallback = UserFeignClientImpl.class)
//@LoadBalancerClient(name="user-service",configuration  = UserFeignClientImpl.class)
public interface UserFeignClient {
	
	@PostMapping("/users")
	public ResponseEntity<UserEntity> addUser(@RequestBody  UserDTO userDTO);
	
	@GetMapping("/users")
	public ResponseEntity<List<UserEntity>> getAllUser();
	
	@GetMapping("/users/{username}")
	public ResponseEntity<UserDTO> getUser(@PathVariable String username);
	
	@DeleteMapping("/users/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username);
	
	@PutMapping("/users/{username}")
	public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO);
}
