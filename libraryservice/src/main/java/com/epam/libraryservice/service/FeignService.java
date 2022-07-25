package com.epam.libraryservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.epam.libraryservice.entity.BookDTO;
import com.epam.libraryservice.entity.BookEntity;
import com.epam.libraryservice.entity.LoginEntity;
import com.epam.libraryservice.entity.TokenResponseEntity;
import com.epam.libraryservice.entity.UserDTO;
import com.epam.libraryservice.entity.UserEntity;
import com.epam.libraryservice.feign.AuthFeignClient;
import com.epam.libraryservice.feign.BookFeignClient;
import com.epam.libraryservice.feign.UserFeignClient;

@Service
public class FeignService {

	@Autowired
	UserFeignClient userFeignClient;
	@Autowired
	BookFeignClient bookFeignClient;
	@Autowired
	AuthFeignClient authFeignClient;
//	@Autowired
//	Link link;

	public ResponseEntity<UserEntity> addUser(UserDTO userDTO) {
		return userFeignClient.addUser(userDTO);
	}

	public ResponseEntity<List<UserEntity>> getAllUsers() {
		ResponseEntity<List<UserEntity>> allUser = userFeignClient.getAllUser();
//		allUser.getBody().forEach(user -> user.add(link.getUserSelfLink(user)));
		return allUser;
	}

	public ResponseEntity<UserDTO> getUserByUserName(String username) {
		ResponseEntity<UserDTO> user = userFeignClient.getUser(username);
//		user.getBody().add(link.getUserSelfLink(user.getBody()),link.getAllUserLink());
		return user;
	}

	public ResponseEntity<String> deleteUserByUserName(String username) {
		return userFeignClient.deleteUser(username);
	}

	public ResponseEntity<String> updateUser(String username, UserDTO userDTO) {
		return userFeignClient.updateUser(username, userDTO);
	}

	public ResponseEntity<BookEntity> addBook( BookDTO bookDTO) {
		return bookFeignClient.addBook(bookDTO);
	}

	public ResponseEntity<List<BookEntity>> getAllBooks() {
		return bookFeignClient.getAllBook();
	}

	public ResponseEntity<BookEntity> getBookByBookId(int bookId) {
		return bookFeignClient.getBook(bookId);
	}

	public ResponseEntity<String> deleteBookByBookId(int bookId) {
		return bookFeignClient.deleteBook(bookId);
	}

	public ResponseEntity<String> updateBook(int bookId,BookDTO bookDTO) {
		return bookFeignClient.updateBook(bookId, bookDTO);
	}

	public ResponseEntity<TokenResponseEntity> getToken(LoginEntity loginentity) {
		System.out.println(loginentity.toString());
		System.out.println(authFeignClient.getToken(loginentity).getBody());
		return authFeignClient.getToken(loginentity);
	}

	public ResponseEntity<Boolean> verifyToken(String token) {
		return authFeignClient.verifyToken(token);
	}

}
