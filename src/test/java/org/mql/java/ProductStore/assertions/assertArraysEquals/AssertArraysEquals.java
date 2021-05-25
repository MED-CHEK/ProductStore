package org.mql.java.ProductStore.assertions.assertArraysEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;


class AssertArraysEquals {
	@Test
	public void assertArrayEqualsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		String[] actualBookIds = bookService.getIdsByPublisher("Wrox");
		
		assertArrayEquals(new String[] {"1", "3"}, actualBookIds);
	}
	
	@Test
	public void assertArrayEqualsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		String[] actualBookIds = bookService.getIdsByPublisher("Wrox");
		
		assertArrayEquals(new String[] {"1", "3"}, actualBookIds, "bookIds didnt match !");
	}
	
	@Test
	public void assertArrayEqualsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		String[] actualBookIds = bookService.getIdsByPublisher("Wrox");
		
		assertArrayEquals(new String[] {"1", "3"}, actualBookIds, () -> "bookIds didnt match !");
	}
}
