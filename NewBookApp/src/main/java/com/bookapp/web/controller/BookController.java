package com.bookapp.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookNotFoundException;
import com.bookapp.model.dao.BookType;
import com.bookapp.model.dao.user.User;
import com.bookapp.model.dao.user.UserType;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.UserService;
import javax.servlet.http.HttpSession;


@Controller
public class BookController {

	private BookService bookService;
	

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	
	}

	
	@GetMapping("getbook/{id}")
	public ModelAndView getbook(@PathVariable("id") int id, ModelAndView mv) {
		Book book = bookService.getBookById(id);

		mv.setViewName("showbook");
		mv.addObject("book", book);
		return mv;
	}

	@GetMapping("allbooks")
	public ModelAndView allbooks(HttpServletRequest req,ModelAndView mv) {
		mv.setViewName("showall");
		mv.addObject("books", bookService.getAllBooks());
    	mv.addObject("user", req.getSession(false).getAttribute("user"));
		return mv;
	}

	// del the book
	@GetMapping("deletebook")
	public String delBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		bookService.deleteBook(id);
		return "redirect:/allbooks";
	}
	

	// update the book: get and post

	// add an new book
	@GetMapping("updatebook")
	public String addBookGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		Book book = bookService.getBookById(id);
		map.addAttribute("book", book);
		return "updatebook";
	}

	// add an new book
	@GetMapping("addbook")
	public String addBookGet(ModelMap map) {
		// we are binding a form bean ( a poj ie used to collect the data from ui) with
		// the form
		map.addAttribute("book", new Book());
		return "addbook";
	}

	// post part of addbook/updatebook
	@PostMapping("addbook")
	public String addBookPost(@Valid @ModelAttribute(name = "book") Book book, BindingResult bindingResult) {
		// hey spring if there is a validation error : go back to addbook.jsp
		if (bindingResult.hasErrors()) {
			return "addbook";
		} else {
			if (book.getId() == 0) {
				bookService.addBook(book);
			} else {
				bookService.updateBook(book.getId(), book);
			}
			return "redirect:/allbooks";
		}
	}
	
	// hey spring mvc pl execute this method for every req... and put this retrun
	// values of this
	// method in req scope in a variable named "booktypes"
	@ModelAttribute(value = "booktypes")
	public BookType[] bookType() {
		System.out.println("--------------called for each req of this controller ---i can call db");
		return BookType.values();
	}
	
	
	@ExceptionHandler(BookNotFoundException.class)
	public ModelAndView bookNotFoundExHander (Exception ex, HttpServletRequest req) {
		System.out.println("------------%%%%%%%%%%%%%----------");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("booknotfound");
		mv.addObject("error", ex.getMessage());
		return mv;
	}
}





