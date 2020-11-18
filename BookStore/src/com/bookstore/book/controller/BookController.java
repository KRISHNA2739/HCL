package com.bookstore.book.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.model.Book;
import com.bookstore.model.BookDao;
import com.bookstore.model.BookDaoImpl;




@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookDao dao = new BookDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	
		if(action.equals("showbooks")) {
			List<Book> books = dao.getAll();
			request.setAttribute("books", books);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		} else if(action.equals("addbook")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("add_book.jsp");
			dispatcher.forward(request, response);
		} else if(action.equals("deletebook")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			dao.delete(id);
			response.sendRedirect("BookController?action=showbooks");
		}
		else if("update".equals(action)){
			Integer id=Integer.parseInt(request.getParameter("id").trim());
			
			Book book=dao.getById(id);
			request.setAttribute("book", book);
		
			RequestDispatcher rd=request.getRequestDispatcher("update_book.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String pubDateString = request.getParameter("pubDate");
		String priceString = request.getParameter("price");
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate dateTemp = LocalDate.parse(pubDateString, fmt);
		java.sql.Date pubDate=java.sql.Date.valueOf(dateTemp);

		Double price = Double.parseDouble(priceString);
		
		
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		
		if(id==0)
		{
	    Book book = new Book(isbn, title, author, pubDate, price);
		dao.add(book);
		}
		else
		{
			dao.update(id, price);
		}
		
		response.sendRedirect("BookController?action=showbooks");
	}
}
