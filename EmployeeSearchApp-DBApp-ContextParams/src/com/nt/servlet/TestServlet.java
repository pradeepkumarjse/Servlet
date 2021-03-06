package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		//access ServletContext obj
		ServletContext sc=getServletContext();
		pw.println("db user context parameter value: "+sc.getInitParameter("dbuser"));
		pw.println("<br> p1 context parameter value:  "+sc.getInitParameter("p1"));
		pw.println("<br> ServletContext  obj class name: "+sc.getClass());
		
		//access ServletConfig Object
		ServletConfig cg=getServletConfig();
		pw.println("<br> ServletConfig p1 paramenter val:  "+cg.getInitParameter("p1"));
		
		pw.close();
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
