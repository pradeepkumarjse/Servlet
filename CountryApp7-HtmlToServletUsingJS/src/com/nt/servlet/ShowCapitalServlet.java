package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCapitalServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter object
		PrintWriter pw=resp.getWriter();
		
		//set resp content type
		resp.setContentType("text/html");
		//read req parameter value
		int countryCode=Integer.parseInt(req.getParameter("country"));
		
		//prepare capitals
		String capitals[]=new String[] {"New Delhi","Beiging","WashingtonDC","Dhaka"};
		
		//write result to resp object
		pw.println("<h1 style='color:green;text-align:center;'>Capital is :   "+capitals[countryCode-1]+"</h1>");
		
		//add home hyperlink
		pw.println("<center><a href='form.html'>Home</a><center>");
		
		//close stream
		pw.close();
		
		
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
		
		
		
	}

}
