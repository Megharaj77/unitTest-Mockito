package com.skillsoft.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//@ExtendWith(MockitoExtension.class)
//public class BookServiceTest {
//
//	@Mock
//	private BookRepository bookRepositoryMock;
//	
//	@InjectMocks
//	private BookService bookService;
//	
//	@Test
//	public void testAddBooks() {
//		
//		doNothing().when(bookRepositoryMock).addBook(isA(Book.class));
//		
//		bookService.addBook(new Book("book123", "Diary of Wimpy kid", "Jeff Kinney"));
//		bookService.addBook(new Book("book456", "Game of Thrones", "George R. R. Martin"));
//		bookService.addBook(new Book("book789", "Hunger Games", "Suzanne Collins"));
//		
//		verify(bookRepositoryMock, times(3)).addBook(isA(Book.class));
//		
//	}
//	
//	@Test
//	public void testUpdateBook() {
//		
//		doNothing().when(bookRepositoryMock).updateBook(isA(Book.class));
//		
//		bookService.updateBook(new Book("book123", "Diary of a Wimpy Kid(Series)", "Jeff Kinney"));
//		
//		verify(bookRepositoryMock, atLeastOnce()).updateBook(isA(Book.class));
//	}
//	
//	@Test
//	public void testDeleteBook() {
//		
//		doNothing().when(bookRepositoryMock).deleteBook(anyString());
//		
//		bookService.deleteBook("book123");
//		
//		verify(bookRepositoryMock, atLeastOnce()).deleteBook(anyString());
//	}
//	
//}







/*Argument captors*/

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	@Captor
	ArgumentCaptor<Book> inputBookCaptor;
	
	@Captor
	ArgumentCaptor<String> inputStringCaptor;
	
	@Test
	public void testAddBooks() {
		
//		ArgumentCaptor<Book> inputBookCaptor = ArgumentCaptor.forClass(Book.class);
		
		doNothing().when(bookRepositoryMock).addBook(inputBookCaptor.capture());
		
		Book book1 = new Book("book456", "Game of Thrones", "Geroge R. R. Martin");
		bookService.addBook(book1);
		
		assertEquals(book1, inputBookCaptor.getValue());
		
		bookService.addBook(new Book("book789","Hunger Games", "Suzanne Collins"));
		
		assertEquals(new Book("book789","Hunger Games", "Suzanne Collins"), inputBookCaptor.getValue());
		
		verify(bookRepositoryMock, times(2)).addBook(isA(Book.class));
		
	}
	
	@Test
	public void testUpdateBook() {
		
//		ArgumentCaptor<Book> inputBookCaptor = ArgumentCaptor.forClass(Book.class);
		
		doNothing().when(bookRepositoryMock).updateBook(inputBookCaptor.capture());
		
		bookService.updateBook(new Book("book123", "Diary of a Wimpy Kid(Series)", "Jeff Kinney"));
		bookService.updateBook(new Book("book456", "Game of Thrones", "Geroge R. R. Martin"));
		
		assertTrue(inputBookCaptor.getAllValues().contains(new Book("book123", "Diary of a Wimpy Kid(Series)", "Jeff Kinney")));
		
		assertTrue(inputBookCaptor.getAllValues().contains(new Book("book456", "Game of Thrones", "Geroge R. R. Martin")));
		
		
		verify(bookRepositoryMock, times(2)).updateBook(isA(Book.class));
	}
	

	@Test
	public void testDeleteBook() {
		
//		ArgumentCaptor<String> inputStringCaptor = ArgumentCaptor.forClass(String.class);
		
		doNothing().when(bookRepositoryMock).deleteBook(inputStringCaptor.capture());
		
		bookService.deleteBook("book123");
		
		assertEquals("book123", inputStringCaptor.getValue());
		
		
		verify(bookRepositoryMock, atLeastOnce()).deleteBook(anyString());
	
	}
}
