package com.bookapp.web.controller;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookType;
import com.bookapp.model.service.BookService;

public class Demo {

	public static void main(String[] args) {
		/*ApplicationContext ctx=new ClassPathXmlApplicationContext("model-config.xml");
		Book book=new Book("WE12", "java", "raj", new Date(), 500, BookType.IT);
		BookService bookService=ctx.getBean("bs", BookService.class);
		bookService.addBook(book);*/
		
		System.out.println("---------");
	}
}
