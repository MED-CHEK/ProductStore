package org.mql.java.ProductStore.assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mql.java.ProductStore.livre.model.Book;
import org.mql.java.ProductStore.livre.service.BookService;


public class AssertTrueDemo {
	
	@Test
	public void assertTrueWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		
		//bookService.addBook(headFirstJavaBook);
		
		List<Book> list = bookService.getList();
		
		assertTrue(list.isEmpty());
	}
		
}
