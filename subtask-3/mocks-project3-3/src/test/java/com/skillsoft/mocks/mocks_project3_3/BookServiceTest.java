package com.skillsoft.mocks.mocks_project3_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	@Test
	public void testGetBooks() throws BookNotFoundException{
		doThrow(BookNotFoundException.class)
		       .when(bookRepositoryMock)
		       .deleteBook(anyString());
		
		try {
			bookService.deleteBook("asd123");
			
			fail();
		} catch(Exception ex) {
			assertTrue(ex instanceof BookNotFoundException);
			
		}
	}
	
}
