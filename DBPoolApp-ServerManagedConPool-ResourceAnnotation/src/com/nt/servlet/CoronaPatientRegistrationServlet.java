package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/poolurl")
public class CoronaPatientRegistrationServlet extends HttpServlet {

	private static final String CORONA_PATIENT_INSERT_QUERY="INSERT INTO CORONA_PATIENT VALUES(PATIENT_ID_SEQ.NEXTVAL,?,?,?)";
	
	//Dependency Injection
	@Resource(name="Dsjndi")
	private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		//set resp content type
		resp.setContentType("text/html");
		
		String name=req.getParameter("pname");
		String address=req.getParameter("paddrs");
		long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		
		
		//write JDBC code for completing registration process
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//get pooled jdbc connection object
			con=ds.getConnection();
			//create PreparedStatement object having INSERT SQL query
			ps=con.prepareStatement(CORONA_PATIENT_INSERT_QUERY);
			//set value to query params
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setLong(3,mobileNo);
			
			
			//execute the query
			int result=ps.executeUpdate();
			
			
			//process the result
			if(result==0) {
				pw.println("<h1 style='color:red;text-align:center'>Problem in patient registration</h1>");
			}
			else {
				pw.println("<h1 style='color:green;text-align:center'>Patient registration completes successfully!</h1>");
				
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Problem in Database Connectivity</h1>");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unknown problem!</h1>");
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		
		//add hyperlink
		pw.println("<br><br><h1 style='text-align:center'><a href='input.html'>Home</a></h1>");
	
		
		
	}//doGet(-.-)
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}//doPost(-,-)
	
}
