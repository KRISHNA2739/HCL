package com.krishna.anjanee_krishna;

import java.util.List;

public interface BookDao
{
	List<Book> getAllBooks();
	Book upBook( int id,int page );
    Book delBook( int id );
    void addBook(Book book );
}