package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read form data
		String ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
		String url=null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?p="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("ask"))
			url="https://www.ask.com/web?q="+ss;
		
		
		//perform send redirection
		System.out.println("Before sendRedirection");
		
		res.sendRedirect(url);
	
		System.out.println("After sendRedirection");
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
