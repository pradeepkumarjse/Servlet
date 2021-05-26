package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProcessingServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		
		//set resp Content type
		resp.setContentType("text/html");
		
		//read form data
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		String qualification=req.getParameter("qualification");
		String[] favCities=req.getParameterValues("cities");
		String[] hbs=req.getParameterValues("hb");
		String favColor=req.getParameter("favColor");
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String email=req.getParameter("email");
		String fbUrl=req.getParameter("fbUrl");
		long mobNo=Long.parseLong(req.getParameter("mobNo"));
		int salary=Integer.parseInt(req.getParameter("salary"));
		String bWeek=req.getParameter("bWeek");
		String bMonth=req.getParameter("bMonth");
		
		
		
		//handle non select state of list and check boxes
		if(ms==null)
			ms="single";
		if(hbs==null)
			hbs=new String[] {"no hobbies are selected"};
		if(favCities==null)
			favCities=new String[] {"no cities are selected"};
		
		
		//write business logic or request processing logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
			pw.println("<h1 style='color:green'>Mr. "+name+" You are Baby boy</h1>");
			else if(age<13)
				pw.println("<h1 style='color:green'>Mr. "+name+" You are small boy</h1>");
			else if(age<20)
				pw.println("<h1 style='color:green'>Mr. "+name+" You are teenage boy</h1>");
			else if(age<35)
				pw.println("<h1 style='color:green'>Mr. "+name+" You are Young man</h1>");
			else if(age<50)
				pw.println("<h1 style='color:green'>Mr. "+name+" You are middle age man</h1>");
			
			else
				pw.println("<h1 style='color:green'>Mr. "+name+" You are Buddha</h1>");
		}
		
		else {
			if(age<5)
				pw.println("<h1 style='color:green'>Mr. "+name+" You are Baby girl </h1>");
			else if(age<13)
				pw.println("<h1 style='color:green'>Mr. "+name+" You are small girl</h1>");
			else if(age<20) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:green'>Mrs."+name+"  u  r  Married teenage girl </h1>");
			    else
					pw.println("<h1 style='color:green'>Miss."+name+" u  r   teenage girl</h1>");
			}
			else if(age<50) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:green'>Mrs."+name+"  u  r  middle-aged woman </h1>");
				else
					pw.println("<h1 style='color:green'>Miss."+name+"  u  r  middle-aged woman </h1>");
			}
			
			else {
				if(ms.equalsIgnoreCase("married"))
				       pw.println("<h1 style='color:green'>Mrs."+name+"  u  r married old woman </h1>");
				  else
					  pw.println("<h1 style='color:green'>Miss."+name+"  u  r old woman </h1>");
				
			}//else
			
		}//else	
		
		
		
		//pritn all form data
		pw.println("<h2 style='color:red; text-align:center;'>Form data is :</h2>");
		pw.println("<br><b>Name : "+name+"</b>");
		pw.println("<br><b>Age :"+age+"</b>");
		pw.println("<br><b>Address :"+address+"</b>");
		pw.println("<br><b>Gender :"+gender+"</b>");
		pw.println("<br><b>Merital Status :"+ms+"</b>");
		pw.println("<br><b>Qualification :"+qualification+"</b>");
		pw.println("<br><b>Fav Cities :"+Arrays.toString(favCities)+"</b>");
		pw.println("<br><b>Hobbies :"+Arrays.toString(hbs)+"</b>");
		pw.println("<br><b>Fav Color :"+favColor+"</b>");
		pw.println("<br><b>Date of Birth :"+dob+"</b>");
		pw.println("<br><b>Time of Birth :"+tob+"</b>");
		pw.println("<br><b>Email :"+email+"</b>");
		pw.println("<br><b>Facebook url :"+fbUrl+"</b>");
		pw.println("<br><b>Mobile No :"+mobNo+"</b>");
		pw.println("<br><b>Salary :"+salary+"</b>");
		pw.println("<br><b>Birth Week :"+bWeek+"</b>");
		pw.println("<br><b>Birth Month :"+bMonth+"</b>");
		
		
		//add hyperlink
		pw.println("<h1><br><a href='form.html'>Home</a></h1>");
		
		//close stream
		pw.close();
		
	}//doGet(-,-)
	
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	doGet(req,resp);		
		
	}//doPost(-,-)

}//class
