package com.bankapp.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.model.dao.user.User;



@WebFilter(urlPatterns= "*.do")
public class LoginCheckerFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		System.out.println("i am in filter f1");
		boolean isValid=false;
		

		HttpSession httpSession=req.getSession(false);
		
		if(httpSession!=null){
			User user=(User) httpSession.getAttribute("user");
			if(user!=null){
				isValid=true;
			}
		}
		
		
		if(isValid){
		chain.doFilter(request, response);
		}else{
			
			res.sendRedirect("/NewBankApp/loginuser");
			return ;
		}
	}

	public void destroy() {
		
	}

}
