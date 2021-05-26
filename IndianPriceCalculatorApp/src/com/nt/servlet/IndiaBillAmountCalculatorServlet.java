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

@WebServlet("/indiacalcurl")
public class IndiaBillAmountCalculatorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set resp content type
		res.setContentType("text/html");
		
		//read for data
		String itemName=req.getParameter("iname");
		float price=Float.parseFloat(req.getParameter("iprice"));
		int qty=Integer.parseInt(req.getParameter("iqty"));
		
		//calc bill amount
		float billAmount=price*qty;
		float tax=billAmount*0.12f;
		float finalAmount=billAmount+tax;
		
		//display details
		pw.println("<h1 style='color:green;text-align:center;'>India</h1>");
		pw.println("<center>");
		pw.println("<p><b>Bill Amount: </b>"+billAmount+"</p>");
		pw.println("<p><b>Tax(GST) : </b>"+tax+"</p>");
		pw.println("<p><b>Final Amount: </b>"+finalAmount+"</p>");
		pw.println("<center>");
		
		//include the response of USBillAmountCalculatorServlet of USPriceCalculatorApp
		try {
			//get ServletContext obj of current web application
			ServletContext sc=getServletContext();
			
			//get ForeignContext of destinaltion web app(USPriceCalculatorApp)
			ServletContext fc=sc.getContext("/USPriceCalculatorApp");
			
			
			//create RequestDispatcher obj pointing to Destination servlet comp. (USBillAmountCalculatorServlet)
			RequestDispatcher rd=fc.getRequestDispatcher("/uscalcurl");
			//include the response
			rd.include(req,res);
			
			//add home hyperlink
			pw.println("<h4 style='text-align:center;'><a href='input.html'>Home</a></h4>");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
