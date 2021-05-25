package org.mql.java.ProductStore.livre.model;

public class Book {
	
	private String id;
	private String title;
	private String publisher;
	
	public Book(String bookId, String title, String publisher) {
		this.id = bookId;
		this.title = title;
		this.publisher = publisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
