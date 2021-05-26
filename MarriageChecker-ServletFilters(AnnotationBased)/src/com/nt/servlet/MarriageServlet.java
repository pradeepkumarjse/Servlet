package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/marriageurl")
public class MarriageServlet extends HttpServlet{
	
	
	
	
	
	public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		
		//fetch data from request obj		
		String name=req.getParameter("pname").trim();
		String tage=req.getParameter("page").trim();
		String address=req.getParameter("paddress").trim();
		//
		String vstatus=req.getParameter("vflag").trim();//gives yes or no
		
		
		//enable form validation logic(server side ) only if vstatus is "no"  only client side validations are not done)
		int age=0;
		
		
		
		
		
		if(vstatus.equalsIgnoreCase("no")) {
		//form validation login(server side)
		System.out.println("form validation logic server side");
		List<String> errorList=new ArrayList<>();
		
		//on person name
		if(name==null || name.length()==0 || name.equals(""))//required rule
			errorList.add("Person name is required");
		else if(name.length()<5)
			errorList.add("Person name must have mininum 10 characters");// minimum length rule
		
		//on person age
		
		try {
			age=Integer.parseInt(tage);
			if(age<1 || age>125)
				errorList.add("Person age must between 1 and 125");//range rule
			
		}catch(NumberFormatException e) {
			errorList.add("Person age must be numeric value");//numeric value rule
			
		}
		//on person address
		if(address==null || address.length()==0 || address.equals(""))
			errorList.add("Person address is required");
		
		//display form validation error
		if(errorList.size()!=0) {
			pw.println("<ul style='color:red;'>");
				for(String errMsg:errorList)
					pw.println("<li>"+errMsg+"</li>");
			pw.println("</ul>");
			return;
		}
		}
		else {
			
			 age=Integer.parseInt(tage);
		}
		
			
		
		//write business logic or request processing logic
		if(age>21)
			pw.println("<h1 style='color:red; text-align:center;'>Hello, Mr/Mrs/Miss. "+name+" You are ready to get marry!!!</h1>");
		else
			pw.println("<h1 style='color: red; text-align:center;'>Sorry, "+name+"  you are not eligible for marriage please wait some time you will get married soon!</h1>");
		
		pw.println("<center><a href='input.html'><img src='images/home.png'></a></center>");
		pw.close();
		
	}
	

	
	
	
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		processGet(req,res);
		
	}
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		processPost(req,res);
		
	}
	
  
	
	
	
	public void processGet(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException{
		//get printwriter obj
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		
		Date d=new Date();
		
		//writing to printWriter
		pw.println("<h1 style='color:red; text-align:center;'> Syatem date and time is :"+d+"</h1>");
		
		pw.println("<center><a href='input.html'><img src='images/home.png'></center>");
		//close stream
		pw.close();	
		
	}

}
