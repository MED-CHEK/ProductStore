package org.mql.java.ProductStore.assumptions.assumingThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;

public class AssumingThatDemo {

	@Test
	public void assumingThatWithBooleanCondition() {
		
		
		assumingThat("DEV".equals(System.getProperty("ENV")), () -> {
			System.out.println("Dev environment !!!");
			BookService bookService = new BookService();
			
			Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
			Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
			
			bookService.addBook(headFirstJavaBook);
			bookService.addBook(headFirstDesignPatternBook);

			Book actualBook = bookService.getById("4");
			assertNull(actualBook);
		});
		// below code gets executed in every environment
		System.out.println("Executed in every environment !!!");
	}

	@Test
	public void assumingThatWithBooleanSupplier() {
		assumingThat(() -> "DEV".equals(System.getProperty("ENV")), () -> {
			System.out.println("Dev environment !!!");
			assertEquals(5, 3 + 2);
		});
		// below code gets executed in every environment
		System.out.println("Executed in every environment !!!");
		assertEquals(3, 2 + 1);
	}

}
