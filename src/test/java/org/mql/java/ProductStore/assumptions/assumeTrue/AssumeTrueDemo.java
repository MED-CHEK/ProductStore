package org.mql.java.ProductStore.assumptions.assumeTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;

public class AssumeTrueDemo {
	
	@Test
	public void assumeTrueWithNoMessage() {
		BookService bookService = new BookService();
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		bookService.addBook(headFirstJavaBook);
		
		boolean exist = true; 
		if(bookService.getByTitle("Head First Java") != null) {
			exist = false;
		}
		assumeTrue(exist);
		
		System.out.println("Assumption passed !!!");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		bookService.addBook(headFirstDesignPatternBook);
		Book actualBook = bookService.getById("2");
		assertNotNull(actualBook);
	}
	
	@Test
	public void assumeTrueWithMessage() {
		assumeTrue("DEV".equals(System.getProperty("ENV")), "Assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeTrueWithMessageSupplier() {
		assumeTrue("DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeTrueWithBooleanSupplierAndNoMessage() {
		assumeTrue(() -> "DEV".equals(System.getProperty("ENV")));
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeTrueWithBooleanSupplierAndMessage() {
		assumeTrue(() -> "DEV".equals(System.getProperty("ENV")), "Assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumeTrueWithBooleanSupplierAndMessageSupplier() {
		assumeTrue(() -> "DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed !!!");
		
		System.out.println("Assumption passed !!!");
		assertEquals(3, 2 + 1);
	}
	
}
