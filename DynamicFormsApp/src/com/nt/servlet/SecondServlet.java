package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set res content type
		res.setContentType("text/html");
		

		//read form1/req1 data(will not come)
		String pname=req.getParameter("pname");
		String pfname=req.getParameter("pfname");
		String address=req.getParameter("address");
		String ms=req.getParameter("ms");
		
		//read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		
		//genereate dynamic web page displaying both form1/req1 and form2/req2 data
		pw.println("<h2 style='color:red;text-align:center'>Form1/req1 Data:  "+pname+" : "+pfname+" : "+address+" : "+ms+"</h2>");
		pw.println("<h2 style='color:red;text-align:center'>Form2/req2 Data:  "+f2val1+" : "+f2val2+"</h2>");
		
		//add home hyperlink
		pw.println("<h3 style='text-align:center;'><a href='form.html'>Home</a></h3>");
		
		
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
