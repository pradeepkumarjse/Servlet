package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiSubmitServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		//set resp content type
		resp.setContentType("text/html");
		
		String pval=req.getParameter("s1");
		
		float num1=0.0f;
		float num2=0.0f;
		
		if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
		 num1=Float.parseFloat(req.getParameter("n1"));
	     num2=Float.parseFloat(req.getParameter("n2"));
		
		}
	     if(pval.equalsIgnoreCase("add")) {
	    	 float result=num1+num2;
			pw.println("<h1 style='color:green;text-align:center;'>Sum is :"+result+"</h1>");
			
		}
		else if(pval.equalsIgnoreCase("sub")) {
			float result=num1-num2;
			pw.println("<h1 style='color:green;text-align:center;'>Substraction is :"+result+"</h1>");
		}
		else if(pval.equalsIgnoreCase("mul")) {
			float result=num1*num2;
			pw.println("<h1 style='color:green;text-align:center;'>Multiplication is :"+result+"</h1>");
		}
		else if(pval.equalsIgnoreCase("div")) {
			float result=num1/num2;
			pw.println("<h1 style='color:green;text-align:center;'>Division is :"+result+"</h1>");
		}
		else if(pval.equalsIgnoreCase("link1")) {
			Date d=new Date();
			pw.println("<h1 style='color:green;text-align:center;'>System date is :"+d.toString()+"</h1>");
		}
		else {
			Properties props=System.getProperties();
			pw.println("<h1 style='color:green;text-align:center;'>System Properties is :"+props+"</h1>");
			
		}	
		
		
		
		//Add form home hyperlink
		pw.println("<center><a href='form.html'><img src='images/home.png'></a></center>");
		
		
		//close stream
		pw.close();
		
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		doGet(req,resp);
		
	}

}
