package com.bookapp.model.service;

import java.util.List;
import java.util.function.Predicate;

import com.bookapp.model.dao.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public Book deleteBook(int id);
	public Book updateBook(int id, Book book);
	public Book getBookById(int id);
	public List<Book> getBookOnCondition(Predicate<Book>predicate);
}
