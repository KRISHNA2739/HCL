package com.bankapp.web.interceptorfilter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bankapp.model.dao.user.User;

public class LoginCheckerinterceptorFilter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
boolean isvalid=false;
		HttpSession httpSession = request.getSession(false);
		if (httpSession != null) {
			User user = (User) httpSession.getAttribute("user");
			if (user != null) {
				isvalid=true;
			}
			else
			{
				response.sendRedirect("/NewBankApplication/loginuser");
			}
		}

		return isvalid;
	}

}
