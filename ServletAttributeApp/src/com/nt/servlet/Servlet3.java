package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw =res.getWriter();
		//set resp content ytpe
		res.setContentType("text/html");
		pw.println("<h1>Servlet3: request atribute value "+req.getAttribute("attr1")+"</h1>");
		
		//read and display session attribute value
		HttpSession ses=req.getSession();
		pw.println("<h1 style='color:green;text-align:center;>Servlet3: request atribute value "+ses.getAttribute("attr2")+"</h1>");
		
		//read and display ServletContext attribute value
		ServletContext sc=req.getServletContext();
		int reqCount=(int)sc.getAttribute("reqCount");
		pw.println("<h1 style='color:green;text-align:center;'>Servlet3: request atribute value "+reqCount+"</h1>");
		
		//forward this request to servlet comp4 
		RequestDispatcher rd=req.getRequestDispatcher("/s4url");
		rd.forward(req, res);
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
