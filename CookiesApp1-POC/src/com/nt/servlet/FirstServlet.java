package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set res content type
		res.setContentType("text/html");
		
		//create InMemory cookies
		Cookie ck1=new Cookie("DEL","NewDelhi");
		res.addCookie(ck1);
		
		//create Persistance cookie
		Cookie ck2=new Cookie("TS","Hyderabad");
		ck2.setMaxAge(120);
		res.addCookie(ck2);
		
		pw.println("<h2 style='test-align:center;color:green;'>Cookies are created and successfully! added to res obj.</h2>");
		//close stream
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
