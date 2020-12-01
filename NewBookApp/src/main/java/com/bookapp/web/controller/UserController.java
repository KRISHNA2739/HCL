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
public class UserController {

	private UserService userservice;

	@Autowired
	public UserController(UserService userservice) {

		this.userservice = userservice;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/loginuser";
	}

	@GetMapping("loginuser")
	public String loginuser(ModelMap map) {
		// we are binding a form bean ( a poj ie used to collect the data from ui) with
		// the form
		map.addAttribute("user", new User());
		return "loginuser";
	}

	@PostMapping("loginuser")
	public String userlogin(HttpServletRequest req, @Valid @ModelAttribute(name = "user") User user,
			BindingResult bindingResult) {
		// hey spring if there is a validation error : go back to addbook.jsp
		if (bindingResult.hasErrors()) {
			return "loginuser";
		} else {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if (userservice.getUser(username, password) != null) {
			    HttpSession httpSession = req.getSession(false);
				httpSession.setAttribute("user", userservice.getUser(username, password));
          
				return "redirect:/allbooks";
			} else
				return "redirect:/loginuser";
		}
	}

	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		HttpSession httpSession = req.getSession(false);// looking for preexisting session
		if (httpSession != null) {
			httpSession.invalidate();
		}
		return "redirect:/loginuser";

	}

	@GetMapping("adduser")
	public String adduserGet(ModelMap map) {
		// we are binding a form bean ( a poj ie used to collect the data from ui) with
		// the form
		map.addAttribute("user", new User());
		return "adduser";
	}

	@PostMapping("adduser")
	public String adduserPost(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult) {
		// hey spring if there is a validation error : go back to addbook.jsp
		if (bindingResult.hasErrors()) {
			return "adduser";
		} else {
			userservice.addUser(user);

			return "redirect:/allbooks";
		}
	}

	@ModelAttribute(value = "userTypes")
	public UserType[] userType() {
		return UserType.values();
	}

}
