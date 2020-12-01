package com.bookapp.model.dao;

public class BookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7863778402740391518L;

	public BookNotFoundException(String message) {
		super(message);
	}
}
