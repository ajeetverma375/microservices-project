package com.epam.libraryservice.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.libraryservice.entity.BookDTO;
import com.epam.libraryservice.entity.BookEntity;

@FeignClient(url="localhost:8082/books" ,name="book-service")
@LoadBalancerClient(name="book-service")
public interface BookFeignClient {

	@PostMapping("")
	public ResponseEntity<BookEntity> addBook(@RequestBody @Valid BookDTO bookDTO);

	@GetMapping("")
	public ResponseEntity<List<BookEntity>> getAllBook(); 

	@GetMapping("/{bookId}")
	public ResponseEntity<BookEntity> getBook(@PathVariable int bookId); 

	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId); 

	@PutMapping("/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable int bookId, @RequestBody @Valid BookDTO bookDTO); 
}
