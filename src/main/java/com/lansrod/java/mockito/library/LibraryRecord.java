/**
 *
 * @author Omran TOUJANI
 *
 *
 * Copyright 2018 Omran TOUJANI
 *
 *
 */
package com.lansrod.java.mockito.library;

import java.util.Date;

public class LibraryRecord {

	private Long id;

	private Book book;

	private Date borrowingDate;

	private Date returningDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getBorrowingDate() {
		return borrowingDate;
	}

	public void setBorrowingDate(Date borrowingDate) {
		this.borrowingDate = borrowingDate;
	}

	public Date getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}

}
