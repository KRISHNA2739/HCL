package com.bookstore.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.user.model.User;
import com.bookstore.user.model.UserDao;
import com.bookstore.user.model.UserDaoImpl;
import com.bookstore.user.model.UserNotFoundException;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDaoImpl();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession httpSession = request.getSession();
		try {
			User user = userDao.getUser(username, password);

			if(user != null)
			{
				
			httpSession.setAttribute("user", user);
			
			response.sendRedirect("BookController?action=showbooks");
			}
			else
			{
				
				throw new UserNotFoundException("not found");
			
			}
		} catch (UserNotFoundException ex) {
	
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	
}






