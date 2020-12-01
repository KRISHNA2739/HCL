package com.bookapp.model.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;
//service layer... service layer =BL +CCC

@Service(value="bs")
@Transactional // it using aop (around advie ) to do decleartive tx mgt!
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book>books=bookDao.getAllBooks();
		
		return books;
	}

	@Override
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public Book deleteBook(int id) {
		return bookDao.deleteBook(id);
	}

	@Override
	public Book updateBook(int id, Book book) {
		return bookDao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	public List<Book> getBookOnCondition(Predicate<Book> predicate) {
		return getAllBooks().stream().filter(predicate).collect(Collectors.toList());
	}

}
