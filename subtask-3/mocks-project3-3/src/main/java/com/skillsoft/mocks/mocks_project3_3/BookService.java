package com.skillsoft.mocks.mocks_project3_3;

import java.util.List;

public class BookService {

private BookRepository repository;
	

    public Book getBook(String id) {
    	try {
    		return repository.getBook(id);
    	}catch(BookNotFoundException ignored) {
    		
    	}
    	return null;
    }
	
	public List<Book> getBooks(String query){
		return repository.getBooks(query);
		
	}
	
	public void addBook(Book book) {
		repository.addBook(book);
	}
	
	public void updateBook(Book book) {
		repository.updateBook(book);
	}
	
	public void deleteBook(String id) throws BookNotFoundException {
		repository.deleteBook(id);
	}
}
