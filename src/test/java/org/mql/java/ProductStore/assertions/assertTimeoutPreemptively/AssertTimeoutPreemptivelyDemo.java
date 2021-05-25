package org.mql.java.ProductStore.assertions.assertTimeoutPreemptively;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;

public class AssertTimeoutPreemptivelyDemo {

	@Test
	public void assertTimeoutPreemptivelyWithNoMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitlesByPublisher("Wrox"));
		});
		
		assertEquals(1000, actualTitles.size());
		
	}
	
	@Test
	public void assertTimeoutPreemptivelyWithMessage() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitlesByPublisher("Wrox"));
		}, "Performance issues with getBookTitlesByPublisher() method !");
		
		assertEquals(1000, actualTitles.size());
		
	}
	
	@Test
	public void assertTimeoutPreemptivelyWithMessageSupplier() {
		BookService bookService = new BookService();
		
		for(int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
		}
		
		List<String> actualTitles = new ArrayList<>();
		
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getTitlesByPublisher("Wrox"));
		}, () -> "Performance issues with getBookTitlesByPublisher() method !");
		
		assertEquals(1000, actualTitles.size());
		
	}
	
}
