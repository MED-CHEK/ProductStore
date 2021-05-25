package org.mql.java.ProductStore.assertions.assertIterableEquals;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;


public class AssertIterableEqualsDemo {
	
	@Test
	public void assertIterableEqualsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		List<String> actualTitles = bookService.getTitlesByPublisher("Wrox");
		
		List<String> expectedTitles = new ArrayList<>();
		expectedTitles.add("Head First Java");
		expectedTitles.add("Head First Javascript");
		
		assertIterableEquals(expectedTitles, actualTitles);
		
	}
	
	@Test
	public void assertIterableEqualsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
			
		List<String> actualTitles = bookService.getTitlesByPublisher("Wrox");
		
		List<String> expectedTitles = new ArrayList<>();
		expectedTitles.add("Head First Java");
		expectedTitles.add("Head First Javascript");
		
		assertIterableEquals(expectedTitles, actualTitles, "Book titles didnt match !");
	}
	
	@Test
	public void assertIterableEqualsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		List<String> actualTitles = bookService.getTitlesByPublisher("Wrox");
		
		List<String> expectedTitles = new ArrayList<>();
		expectedTitles.add("Head First Java");
		expectedTitles.add("Head First Javascript");
		
		assertIterableEquals(expectedTitles, actualTitles, () -> "Book titles didnt match !");
	}
}
