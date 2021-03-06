package com.nt.error;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set resp content type
		res.setContentType("text/html");
		
		//place non-technical guiding message to end user
		pw.println("<h2 style='color:red;text-align:center;'>Internal problem...please try again..</h2>");
		//home hyperlink
		pw.println("<h3 style='color:blue;text-align:center;'><a href='input.html'>Home</a></h3>");
		
		//close stream
		pw.close();
		
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req, res);
		
	}
}
