/**
 *
 * @author Omran TOUJANI
 *
 *
 * Copyright 2018 Omran TOUJANI*
 *
 */
package com.lansrod.java.mockito.library;

public interface LendingManager {

	public LibraryRecord borrowBook(Book book);

	public LibraryRecord returnBook(Book book);

}
