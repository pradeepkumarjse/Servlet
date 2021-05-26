package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uscalcurl")
public class USBillAmountCalculatorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set resp content type
		res.setContentType("text/html");
		//read form data
		String itemName=req.getParameter("iname");
		float price=Float.parseFloat(req.getParameter("iprice"));
		int qty=Integer.parseInt(req.getParameter("iqty"));
		
		//calculate bill amount
		float billAmount=price*qty;
		float tax1=billAmount*0.18f;
		float tax2=billAmount*0.05f;
		float finalAmount=billAmount+tax1+tax2;
		
		//display details
		pw.println("<h1 style='color:green;text-align:center;'>US</h1>");
		pw.println("<center>");
		pw.println("<p><b>Bill Amount: </b>"+billAmount+"</p>");
		pw.println("<p><b>Tax1(GST):</b> "+tax1+"</p>");
		pw.println("<p><b>Tax2(covidTax):</b> "+tax2+"</p>");
		pw.println("<p><b>Final Amount: </b>"+finalAmount+"</p>");
		pw.println("</center>");
		
		//do not close stream
		//pw.close();
		
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
