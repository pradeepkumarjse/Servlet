package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		//read form1/req1 data
		String pname=req.getParameter("pname");
		String pfname=req.getParameter("pfname");
		String paddrs=req.getParameter("addrs");
		String ms=req.getParameter("ms");
		if(ms==null)
			ms="single";
		
		//genereate form2 dynamically based on merital status
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color:red;text-align:center;'>Submit married life details</h1>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>Spouse name :</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No. of  Kids :</td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			
			pw.println("<tr><td><input type='hidden' name='hname' value='"+pname+"'></td><td><input type='hidden' name='hfname' value='"+pfname+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='haddrs' value='"+paddrs+"'></td><td><input type='hidden' name='hms' value='"+ms+"'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		
		else {
			
			pw.println("<h1 style='color:red;text-align:center;'>Submit Bechalor life details</h1>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>When do want to marry :</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>Why do want to marry :</td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			
			pw.println("<tr><td><input type='hidden' name='hname' value='"+pname+"'></td><td><input type='hidden' name='hfname' value='"+pfname+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='haddrs' value='"+paddrs+"'></td><input type='hidden' name='hms' value='"+ms+"'><td></td></tr>");
			
			
			pw.println("</table>");
			pw.println("</form>");
			
		}
		
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
