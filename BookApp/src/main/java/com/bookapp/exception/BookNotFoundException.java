package com.bookapp.exception;

public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException(String msg) {
		super(msg);
	}
}
