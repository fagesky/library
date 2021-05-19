package org.fogsky.library.service;

import java.util.List;

import org.fogsky.library.model.Book;

public interface BookService {
	int addBook(Book book);
	List<Book> getBook(Book book);
	boolean updateBook(Book book);
	Book getBook(int id);
}
