package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	

	
	
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		
		//read additional paramenter value
		String pval=req.getParameter("s1");
		
		//get all available locale in this world
		
		Locale[] locales=Locale.getAvailableLocales();
		
		//differentiate all logics for hyperlinks in servlet component
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:red;text-align:center;'>All availabe languages are</h1>");
		
		    for(Locale l: locales) {
		    	pw.println("<b>"+l.getDisplayLanguage()+", </b>");
		    	
		    }
		}
		
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h1 style='color:red;text-align:center;'>All availabe Countries are</h1>");
			for(Locale l: locales) {
				pw.println("<b>"+l.getDisplayCountry()+", </b>");
			}
			
		}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>System Properties are</h1>");
			pw.println("<b>"+System.getProperties()+"</b>");
			
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		
		
	}

}
