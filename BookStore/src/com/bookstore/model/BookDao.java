package com.bookstore.model;

import java.util.List;

public interface BookDao {

	public List<Book> getAll();
	public Book add(Book book);
	public void delete(int bookId);
	public Book update(int id, double price);
	public Book getById(int bookId);
	public Book getBookByIsbn(String isbn);
}
