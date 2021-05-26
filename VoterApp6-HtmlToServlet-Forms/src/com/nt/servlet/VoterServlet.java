package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		
		//get PrintWriter obj from resp object
		PrintWriter pw=resp.getWriter();
		//setting response content type
		resp.setContentType("text/html");
		
		//read form data from request obj.
		String name=req.getParameter("pname");
		float age=Float.parseFloat(req.getParameter("page"));
		String address=req.getParameter("paddress");
		
		if(age>18) 
			pw.println("<h1 style='color:red; text-align:center;'>Hello, Mr/Miss/Mrs. "+name+" You are eligible for Voting!</h1>");
		else		
			pw.println("<h1 style='color:red; text-align:center;'> Hello, Mr/Miss/Mrs. "+name+" You are not eligible for Vote!</h1>");
		
		//add graphical hyperlink of home page
		
		pw.println("<center><a href='http://localhost:7070/VoterApp6-HtmlToServlet-Forms/form.html'><img src='images/home.png'></a></center>");
		
		pw.close();
	}

}
