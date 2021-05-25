package org.mql.java.ProductStore.assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;


class aAssertEquals {

	@Test
	public void assertEqualsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		
		Book actualBook = bookService.getById("1");
		
		assertEquals("1", actualBook.getId());
		assertEquals("Head First Java", actualBook.getTitle(), "Book title didnt match!");
	}
	
	
	@Test
	public void assertEqualsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		
		Book actualBook = bookService.getById("1");
		
		assertEquals("1", actualBook.getId());
		assertEquals("Head First Java", actualBook.getTitle());
	}
	
	
	@Test
	public void assertEqualsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		
		Book actualBook = bookService.getById("1");
		
		assertEquals("1", actualBook.getId());
		assertEquals("Head First Java", actualBook.getTitle(), () -> "Book title didnt match!");
	}
}
