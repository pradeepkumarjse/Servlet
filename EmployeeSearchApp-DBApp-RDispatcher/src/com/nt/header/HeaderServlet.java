package com.nt.header;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set resp contet type
		res.setContentType("text/html");
		pw.println("<marquee><img src='images/header.jpg' height='200' width='300'></marquee>");
		//do not close stream
		//pw.close();
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		
		
		doGet(req, res);
	
	}

}
