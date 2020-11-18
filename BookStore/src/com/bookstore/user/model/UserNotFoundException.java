package com.bookstore.user.model;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -2048016409478265725L;

	public UserNotFoundException(String message) {
		super(message);
	}

	
}
