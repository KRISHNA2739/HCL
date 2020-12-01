package com.bookapp.model.dao;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//right now no tx mgt in dao layer
//infact tx must be in service layer... service layer =BL +CCC
@Repository // @Component + excpetion wrapping (PersistenceExceptionTranslationPostProcessor)
public class BookDaoImpl implements BookDao {
	private SessionFactory factory;
	@Autowired
	public BookDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return  getSession().createQuery("from Book").list();
	}

	@Override
	public Book addBook(Book book) {
		Integer id= (Integer) getSession().save(book);
		book.setId(id);
		return book;
	}

	@Override
	public Book deleteBook(int id) {
		Book book = getBookById(id);
		getSession().delete(book);
		return book;
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdated = getBookById(id);
		bookToUpdated.setPrice(book.getPrice());
		getSession().update(bookToUpdated);
		return bookToUpdated;
	}

	@Override
	public Book getBookById(int id) {

		Book book = getSession().get(Book.class, id);

		if (book != null)
			return book;
		else
			throw new BookNotFoundException("book with id:" + id + " is not found");
	}
}
