package com.epam.bookservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.bookservice.entity.BookEntity;

@Service
public interface BookService {

	BookEntity addBook(BookEntity book);

	List<BookEntity> getAllBook();

//	void validateBook(String username, String userName2);

	BookEntity getBookByBookId(int bookId);

	boolean deleteBook(int bookId);

	void validateBook(int existingId, int newId);

}
