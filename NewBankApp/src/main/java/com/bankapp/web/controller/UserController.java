package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.model.dao.user.User;
import com.bankapp.model.dao.user.UserType;
import com.bankapp.model.service.UserService;

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
               if(userservice.getUser(username, password).getUserType()==UserType.ADMIN)
				return "redirect:/accountdetails";
               else
            	   return "redirect:/accountdetail";
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

			return "redirect:/accountdetails";
		}
	}

	@ModelAttribute(value = "userTypes")
	public UserType[] userType() {
		return UserType.values();
	}

}
