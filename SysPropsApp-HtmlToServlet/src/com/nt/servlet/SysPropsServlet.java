package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysPropsServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//get PrintWriter Object from response obj
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get all system properties
		Properties props=System.getProperties();
		//write output to response object
		pw.println(props);
		
		// add home url hyperlink
		pw.println("<br><br><br><center><a href='http://localhost:7070/SysPropsApp-HtmlToServlet/page.html'><img src='images/home.png'></a></center>");
		pw.close();
		
		
	}

}
