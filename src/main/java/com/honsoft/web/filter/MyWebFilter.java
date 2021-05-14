package com.honsoft.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

<<<<<<< HEAD
@WebFilter("/myWebFilter")
=======
@WebFilter
>>>>>>> 596057ef64ea2ede3cde09e86305d28d50fd78c8
public class MyWebFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MyFilter doFilter() is invoked.");
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			System.out.println("Parameter:" + param + "\tValue:" + req.getParameter(param));
		}
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void destroy() {

	}

}