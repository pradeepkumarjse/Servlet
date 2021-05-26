package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("request obj class name: "+req.getClass());
		System.out.println("response obj class name: "+res.getClass());
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		String user=req.getParameter("uname");
		String pass=req.getParameter("pwd");
		System.out.println(user+"..."+pass);
		if(user.equalsIgnoreCase("raja@gmail.com") && pass.equalsIgnoreCase("rani")) {
			
			pw.println("<h1 style='color:green; text-align:center;'>Valid Credential</h1>");
			
		}
		else {
			pw.println("<h1 style='color:green; text-align:center;'>Invalid Credential</h1>");
			
		}
		
		//add home
		pw.println("<h3><a href='login.html'>Home</a></h3>");
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		doGet(req, res);
	}

}
