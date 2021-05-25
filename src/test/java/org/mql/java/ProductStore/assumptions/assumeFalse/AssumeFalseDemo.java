package org.mql.java.ProductStore.assumptions.assumeFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;

public class AssumeFalseDemo {
	@Test
	public void assumeFalseWithNoMessage() {
		BookService bookService = new BookService();
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		bookService.addBook(headFirstJavaBook);
		
		boolean exist = false; 
		if(bookService.getByTitle("Head First Design Pattern") != null) {
			exist = true;
		}
		assumeFalse(exist);
		
		System.out.println("Assumption passed !!!");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		bookService.addBook(headFirstDesignPatternBook);

		Book actualBook = bookService.getById("2");
		assertNotNull(actualBook);
	}
	
	@Test
	public void assumeFalseWithMessage() {
		assumeFalse("DEV".equals(System.getProperty("ENV")), "Our assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeFalseWithMessageSupplier() {
		assumeFalse("DEV".equals(System.getProperty("ENV")), () -> "Our assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeFalseWithBooleanSupplierAndNoMessage() {
		assumeFalse(() -> "DEV".equals(System.getProperty("ENV")));
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeFalseWithBooleanSupplierAndMessage() {
		assumeFalse(() -> "DEV".equals(System.getProperty("ENV")), "Assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeFalseWithBooleanSupplierAndMessageSupplier() {
		assumeFalse(() -> "DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
}
