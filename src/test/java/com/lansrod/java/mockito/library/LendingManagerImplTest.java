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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LendingManagerImplTest {

	@InjectMocks
	LendingManagerImpl manager;

	@Mock
	LibraryRecordDAO dao;

	@Mock
	Book book;

	@Mock
	LibraryRecord oldRecord;

	@Mock
	LibraryRecord newRecord;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(oldRecord.getBorrowingDate()).thenReturn(new Date());
		when(oldRecord.getReturningDate()).thenReturn(new Date());
		when(newRecord.getBorrowingDate()).thenReturn(new Date());
		when(dao.save(any(LibraryRecord.class))).thenReturn(true);
	}

	@Test
	public void testBorrowBook() {
		manager.borrowBook(book);
		verify(dao, times(1)).findByBook(book);
		verify(dao, times(1)).save(any(LibraryRecord.class));
		// Capture the argument of LibraryRecordDAO#save
		ArgumentCaptor<LibraryRecord> captor = ArgumentCaptor.forClass(LibraryRecord.class);
		verify(dao).save(captor.capture());
		LibraryRecord record = captor.getValue();
		assertSame(book, record.getBook());
		assertTrue(new Date().getTime() - record.getBorrowingDate().getTime() >= 0L);
		assertTrue(new Date().getTime() - record.getBorrowingDate().getTime() < 5L);
		assertNull(record.getReturningDate());
		assertNull(record.getId());
	}

	@Test(expected = IllegalStateException.class)
	public void unreturnedBookCanNotBeBorrowed() {
		when(dao.findByBook(book)).thenReturn(Arrays.asList(oldRecord, newRecord));
		manager.borrowBook(book);
	}

	@Test(expected = IllegalStateException.class)
	public void bookCanNotBeBorrowedIfRecordUnsaved() {
		when(dao.save(any(LibraryRecord.class))).thenReturn(false);
		manager.borrowBook(book);
	}

	@Test
	public void testReturnBook() {
		when(dao.findByBook(book)).thenReturn(Arrays.asList(newRecord));
		manager.returnBook(book);
		verify(dao, times(1)).findByBook(book);
		verify(dao, times(1)).save(any(LibraryRecord.class));
	}

	@Test(expected = IllegalStateException.class)
	public void bookCanNotBeReturnedIfRecordIsNotUpdated() {
		when(dao.findByBook(book)).thenReturn(Arrays.asList(oldRecord, newRecord));
		when(dao.save(any(LibraryRecord.class))).thenReturn(false);
		manager.returnBook(book);
	}

	@Test(expected = IllegalStateException.class)
	public void unborrowedBookCanNotBeReturned() {
		when(dao.findByBook(book)).thenReturn(Arrays.asList(oldRecord, newRecord));
		when(newRecord.getReturningDate()).thenReturn(new Date());
		manager.returnBook(book);
	}

	@Test(expected = IllegalStateException.class)
	public void emptyBorrowingDateIsNotAllowed() {
		when(dao.findByBook(book)).thenReturn(Arrays.asList(oldRecord));
		when(oldRecord.getBorrowingDate()).thenReturn(null);
		manager.borrowBook(book);
	}

	@Test(expected = IllegalStateException.class)
	public void moreThan1UnreturnedRecordIsNotAllowed() {
		when(dao.findByBook(book)).thenReturn(Arrays.asList(newRecord, newRecord));
		manager.returnBook(book);
	}

}
