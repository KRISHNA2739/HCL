package com.bookapp.web;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BookService bookService = (BookService) ctx.getBean("bookService");
		
		List<Book> books = bookService.getAllBooks();
		books.forEach(b -> System.out.println(b));
		
		
		
	}
}
