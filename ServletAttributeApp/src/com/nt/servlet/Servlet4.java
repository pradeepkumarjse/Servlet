package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();		
		res.setContentType("text/html");
		//display request attribute value
		pw.println("<h1 style='color:green;text-align:center;'>Servlet4 : Request attribute value :: "+req.getAttribute("attr1")+"</h1>");
		
		
		//read and display session attribute value
		HttpSession ses=req.getSession();
		pw.println("<h1 style='color:green;text-align:center;'>Servlet4 : Request attribute value :: "+ses.getAttribute("attr2")+"</h1>");
		
		//read and display ServletContext attributes
		ServletContext sc=req.getServletContext();
		pw.println("<h1 style='color:green;text-align:center;'>Servlet4 : Request attribute value :: "+sc.getAttribute("reqCount")+"</h1>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
