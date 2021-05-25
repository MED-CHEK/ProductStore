package org.mql.java.ProductStore.assertions.assertTimeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;


public class AssertTimeoutDemo {

	@Test
	public void assertTimeoutWithNoMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeout(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitlesByPublisher("Wrox"));
		});
		
		assertEquals(1000, actualTitles.size());
		
	}
	
	@Test
	public void assertTimeoutWithMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeout(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitlesByPublisher("Wrox"));
		}, "Performance issues with getBookTitlesByPublisher() method !");
		
		assertEquals(1000, actualTitles.size());
		
	}
	
	@Test
	public void assertTimeoutWithMessageSupplier() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeout(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitlesByPublisher("Wrox"));
		}, () -> "Performance issues with getBookTitlesByPublisher() method !");
		
		assertEquals(1000, actualTitles.size());
		
	}
	
}
