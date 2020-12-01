package com.bookapp.model.dao;

import java.util.List;

public interface BookDao {
	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public Book deleteBook(int id);
	public Book updateBook(int id, Book book);
	public Book getBookById(int id);
}
