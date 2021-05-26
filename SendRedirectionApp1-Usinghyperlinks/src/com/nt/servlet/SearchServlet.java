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
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set res content type
		res.setContentType("text/html");
		//read form data
		String ss=req.getParameter("ss");
		
		//generate dynamic web page having hyperlin pointing to Google serach comp;
		pw.println("<h2 style='color:blue;text-align:center;'><a href='https://www.google.com/search?q="+ss+"'>Go to google</a></h2>");
		//close stream
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
