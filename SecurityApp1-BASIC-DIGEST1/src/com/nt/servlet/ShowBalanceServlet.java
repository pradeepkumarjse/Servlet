package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/balanceurl")
public class ShowBalanceServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<h1 style='color:red;'>Authentication mode "+req.getAuthType()+"</h1>");
		pw.println("<h1 style='color:red;'>Loggedin username "+req.getUserPrincipal()+"</h1>");
		
		//write business logic
		pw.println("<h1 style='color:red;text-align:center;'>Account Balance is "+ new Random().nextInt(200000)+"</h1>");
		
		//close stream
		pw.close();
		
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
