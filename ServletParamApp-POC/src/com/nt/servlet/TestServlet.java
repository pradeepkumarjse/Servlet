package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	private ServletConfig cg;
	
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("Driver param init value "+cg.getInitParameter("driver"));
		System.out.println("db user init param value "+cg.getInitParameter("dbuser"));
		this.cg=cg;
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		
		pw.println("<b>Driver param init value "+cg.getInitParameter("driver")+"</br>");
		pw.println("<br><b>db user init param value "+cg.getInitParameter("dbuser")+"</br>");
		
		//close stream
		pw.close();
		
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
