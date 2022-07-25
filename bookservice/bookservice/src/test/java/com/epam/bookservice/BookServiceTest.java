package com.epam.bookservice;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epam.bookservice.entity.BookEntity;
import com.epam.bookservice.exceptions.BookAlreadyExistsException;
import com.epam.bookservice.exceptions.BookDoesNotExists;
import com.epam.bookservice.repository.BookRepository;
import com.epam.bookservice.service.BookServcieImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class BookServiceTest {

	@MockBean
	BookRepository bookRepository;
	@InjectMocks
	BookServcieImpl bookService;
	
	BookEntity book;
	List<BookEntity> bookList=new ArrayList<>();
	@BeforeEach
	public void setUp() {
		book = new BookEntity(1, "ajeet", "ajeet", "ajeet");
		bookList.add(new BookEntity(1, "ajeet", "ajeet", "ajeet"));
		bookList.add(new BookEntity(2, "akash", "akash", "akash"));
	}
		
	@Test
	void TestaddBook()
	{
		when(bookRepository.save(book)).thenReturn(book);
		Assertions.assertEquals(book, bookService.addBook(book));
	}
	
	@Test
	 void addUserAlreadtExistsTest()
	{
		doReturn(Optional.of(book)).when(bookRepository).findById(1);
		when(bookRepository.save(book)).thenReturn(book);
		Assertions.assertThrows(BookAlreadyExistsException.class,()->bookService.addBook(book));
	}
	
	@Test
	void getAllBookTest()
	{
	 when(bookRepository.findAll()).thenReturn(bookList);
		Assertions.assertEquals(bookList, bookService.getAllBook());
	}
	
	@Test
	void getBookByBookIdTest()
	{   	
		doReturn(Optional.of(book)).when(bookRepository).findById(1);
		Assertions.assertEquals(book, bookService.getBookByBookId(1));
	}

	@Test
	void getBookByInvalidBookIdTest()
	{   	
		doReturn(Optional.of(book)).when(bookRepository).findById(1);
		Assertions.assertThrows(BookDoesNotExists.class, ()->bookService.getBookByBookId(2));
	}
	
	@Test
	 void deleteUserByBookIdTest()
	{  
		doReturn(Optional.of(book)).when(bookRepository).findById(1);
		doNothing().when(bookRepository).deleteById(1);
		Assertions.assertEquals(true,bookService.deleteBook(1));
	}
	
	@Test
	 void deleteUserByInvalidUserNameTest()
	{  
		doReturn(Optional.of(book)).when(bookRepository).findById(1);
		doNothing().when(bookRepository).deleteById(1);
		Assertions.assertEquals(false,bookService.deleteBook(2));
	}
}




