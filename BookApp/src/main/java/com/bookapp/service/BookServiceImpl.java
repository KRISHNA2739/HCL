package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.Book;
import com.bookapp.dao.BookDao;

@Service(value = "bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao dao;
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
		
	}

	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}
