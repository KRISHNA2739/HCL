package com.bankapp.model.dao;

public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7863778402740391518L;

	public AccountNotFoundException(String message) {
		super(message);
	}
}
