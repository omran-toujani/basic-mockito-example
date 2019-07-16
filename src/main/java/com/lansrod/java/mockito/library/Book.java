/**
 *
 * @author Omran TOUJANI
 *
 *
 * Copyright 2018 Omran TOUJANI
 *
 * 
 *
 *
 */
package com.lansrod.java.mockito.library;

import java.util.Date;
import java.util.List;

public class Book {

	private Long id;

	private String ISBN;

	private String name;

	private List<String> authors;

	private String publisher;

	private Date publicationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn) {
		ISBN = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

}
