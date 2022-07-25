package com.epam.libraryservice;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epam.libraryservice.entity.UserDTO;
import com.epam.libraryservice.entity.UserEntity;
import com.epam.libraryservice.feign.BookFeignClient;
import com.epam.libraryservice.feign.UserFeignClient;
import com.epam.libraryservice.service.FeignService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
 class FeignServiceTest {

	@InjectMocks
	FeignService feignService;
	@MockBean
	UserFeignClient userFeignClient;
	@MockBean
	BookFeignClient bookFeignClient;
	
//	@Test
//	void addUser() {
//		UserDTO user = new UserDTO("Ajeet@123", "ajeet@gmail.com", "ajeet","ajeet");
//		ResponseEntity<UserEntity> userResponse = new ResponseEntity<>(user, HttpStatus.OK);
//		when(userFeignClient.addUser(user)).thenReturn(userResponse);
//		Assertions.assertEquals(userResponse, feignService.addUser(user));
//	}
	
	@Test
	void testGetAllUsers() {
		List<UserEntity> userList = new ArrayList<>();
		userList.add(new UserEntity("Ajeet@123", "ajeet@gmail.com", "ajeet","pass"));
		userList.add(new UserEntity("Akash@123", "Akash@gmail.com", "Akash","pass"));
		ResponseEntity<List<UserEntity>> reponse = new ResponseEntity<List<UserEntity>>(userList, HttpStatus.OK);
		when(userFeignClient.getAllUser()).thenReturn(reponse);
		Assertions.assertEquals(reponse, feignService.getAllUsers());
	}
	
	@Test
	void testGetUsersByUsername() {
		UserDTO user = new UserDTO("Ajeet@123", "ajeet@gmail.com", "ajeet","pass");
		ResponseEntity<UserDTO> reponse = new ResponseEntity<>(user, HttpStatus.OK);
		when(userFeignClient.getUser("Ajeet@123")).thenReturn(reponse);
		Assertions.assertEquals(reponse, feignService.getUserByUserName("Ajeet@123"));
	}
	
	@Test
	void testGetUsersByInvalidUsername() {
		UserDTO user = new UserDTO("Ajeet@123", "ajeet@gmail.com", "ajeet");
		ResponseEntity<UserDTO> reponse = new ResponseEntity<>(user, HttpStatus.OK);
		when(userFeignClient.getUser("Akash@123")).thenReturn(null);
		Assertions.assertEquals(null, feignService.getUserByUserName("Akash@123"));
	}
}



