/**
 *
 * @author Omran TOUJANI
 *
 *
 * Copyright 2018 Omran TOUJANI
 *
 */
package com.lansrod.java.mockito.library;

import java.util.List;

public interface LibraryRecordDAO {

  public List<LibraryRecord> findByBook(Book book);

  public boolean save(LibraryRecord record);

}
