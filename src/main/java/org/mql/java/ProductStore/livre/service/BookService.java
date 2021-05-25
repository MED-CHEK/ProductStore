package org.mql.java.ProductStore.livre.service;

import java.util.ArrayList;
import java.util.List;

import org.mql.java.ProductStore.livre.exception.BookNotFoundException;
import org.mql.java.ProductStore.livre.model.Book;

public class BookService {
	
	private List<Book> list = new ArrayList<>();
	
	public void addBook(Book book) {
		list.add(book);
	}	
	
	public Book getById(String bookId) {
		for(Book book : list) {
			if(bookId.equals(book.getId())) {
				return book;
			}
		}
		return null;
	}
	
	public String[] getIdsByPublisher(String publisher) {
		List<String> bookIds = new ArrayList<>();
		for(Book book : list) {
			if(publisher.equals(book.getPublisher())) {
				bookIds.add(book.getId());
			}
		}
		return bookIds.toArray(new String[bookIds.size()]);
	}
	
	public List<String> getTitlesByPublisher(String publisher) {
		List<String> bookTitles = new ArrayList<>();
		for(Book book : list) {
			if(publisher.equals(book.getPublisher())) {
				bookTitles.add(book.getTitle());
			}
		}
		return bookTitles;
	}
	
	public Book getByTitle(String title) {
		for(Book book : list) {
			if(title.equals(book.getTitle())) {
				return book;
			}
		}
		throw new BookNotFoundException("Book not found in Bookstore!");
	}

	public List<Book> getList() {
		return list;
	}
	
}
