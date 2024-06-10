package com.sunbeam.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.pojos.User;

public class SecurityFilter implements Filter {
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	    System.out.println("SecurityFilter.init() called.");
	}
	
	@Override
	public void destroy() {
		System.out.println("SecurityFilter.destroy() called.");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) req;
		HttpSession session = rq.getSession();
		User user = (User) session.getAttribute("curuser");
		if(user == null) {
			HttpServletResponse res = (HttpServletResponse) resp;
			res.sendRedirect("index.html");
		}
		else 
			chain.doFilter(rq, resp);
		
	}

}
