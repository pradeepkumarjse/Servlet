package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BrowserCheckingFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("BrowserCheckingFilter.doFilter()");
		String browser=null;
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//get current browser name
		browser=req.getHeader("user-agent");
		if(!browser.contains("Chrome")) {
			pw.println("<h1 style='color:red;text-align:center'> Use chrome browser to visit this website</h1>");
		 return;
		} 
		else {
			System.out.println("BrowserCheckingFilter. before doFilter()");
			chain.doFilter(req, res);
			System.out.println("BrowserCheckingFilter. after doFilter()");
		}//else	
		
	}//doFilter(-,-)

}//class
