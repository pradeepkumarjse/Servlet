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

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set resp content type
		res.setContentType("text/html");
		
		pw.println("<h1 style='color:green;text-align:center;'>Servlet2 : Request attribute value :: "+ req.getAttribute("attr1")+"</h1>");
		
		//read and display session attribute value
		HttpSession ses=req.getSession();
		String attr2=(String)ses.getAttribute("attr2");
		pw.println("<h1 style='color:green;text-align:center;'>Servlet2 : Session attribute value :: "+ attr2+"</h1>");
		
		//read and display session attribute value
		ServletContext sc=getServletContext();
		int reqCount =(int)sc.getAttribute("reqCount");
		pw.println("<h1 style='color:green;text-align:center;'>Servlet2 : ServletContext attribute value :: "+ reqCount +"</h1>");
		
		//forwared this request to servlet3 
		RequestDispatcher rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
