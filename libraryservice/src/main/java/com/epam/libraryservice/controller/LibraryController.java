package com.epam.libraryservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.libraryservice.entity.BookDTO;
import com.epam.libraryservice.entity.BookEntity;
import com.epam.libraryservice.entity.LibraryEntity;
import com.epam.libraryservice.entity.LoginEntity;
import com.epam.libraryservice.entity.TokenResponseEntity;
import com.epam.libraryservice.entity.UserDTO;
import com.epam.libraryservice.entity.UserEntity;
import com.epam.libraryservice.service.FeignService;
import com.epam.libraryservice.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	FeignService feignService;
	@Autowired
	LibraryService libraryService;
	@Autowired
	Environment env;

	@PostMapping("/login")
	public ResponseEntity<TokenResponseEntity> getToken(@RequestBody LoginEntity loginentity) {
		return feignService.getToken(loginentity);
	}

	@PostMapping("/verify")
	public ResponseEntity<Boolean> verifytToken(@RequestHeader("Authorization") String token) {
		return feignService.verifyToken(token);
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserDTO userDTO,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.addUser(userDTO);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserEntity>> getAllUsers(@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.getAllUsers();
	}

	@GetMapping("/users/{username}")
	public ResponseEntity<UserDTO> getUserByUserName(@PathVariable String username,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.getUserByUserName(username);
	}

	@DeleteMapping("/users/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.deleteUserByUserName(username);
	}

	@PutMapping("/users/{username}")
	public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.updateUser(username, userDTO);
	}

	@PostMapping("/books")
	public ResponseEntity<BookEntity> addBook(@RequestBody @Valid BookDTO bookDTO,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.addBook(bookDTO);
	}

	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllBook(@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.getAllBooks();
	}

	@GetMapping("/books/{bookId}")
	public ResponseEntity<BookEntity> getBook(@PathVariable int bookId, @RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.getBookByBookId(bookId);
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId, @RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.deleteBookByBookId(bookId);
	}

	@PutMapping("/books/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable int bookId, @RequestBody @Valid BookDTO bookDTO,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return feignService.updateBook(bookId, bookDTO);
	}

	@GetMapping()
	public ResponseEntity<List<LibraryEntity>> getAllLibraryRecords(@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return new ResponseEntity<>(libraryService.getAllRecords(), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<List<LibraryEntity>> getAllLibraryRecordsByUser(@PathVariable String username,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
//		libraryService.getLibraryDataByUsername(username);
		return new ResponseEntity<>(libraryService.getAllBookByUserName(username), HttpStatus.OK);
	}

	@PostMapping("/users/{username}/books/{bookId}")
	public ResponseEntity<String> isseueBookToUser(@PathVariable String username, @PathVariable int bookId,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		return new ResponseEntity<>(libraryService.issueBookToUser(username, bookId), HttpStatus.OK);
	}

	@DeleteMapping("/users/{username}/books/{bookId}")
	public ResponseEntity<Boolean> releaseBook(@PathVariable String username, @PathVariable int bookId,
			@RequestHeader("Authorization") String token) {
		libraryService.validate(token);
		boolean isDeleted = libraryService.deleteIssuedBook(username, bookId);
		return new ResponseEntity<>(isDeleted, isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
