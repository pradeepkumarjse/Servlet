package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EmployeeSearchServlet extends HttpServlet {
	private static final String GET_EMP_DEATILS_BY_ENO="select empno,ename,desg,sal,deptNo from emp where empno=?";
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get access to ServletConfig Object
		ServletConfig cg=getServletConfig();
		String driver=cg.getInitParameter("driver");
		String url=cg.getInitParameter("url");
		String user=cg.getInitParameter("dbuser");
		String pwd=cg.getInitParameter("dbpwd");
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		int eno=Integer.parseInt(req.getParameter("eno"));
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection(url,user,pwd)){
			try(PreparedStatement ps=con.prepareStatement(GET_EMP_DEATILS_BY_ENO)){
				ps.setInt(1, eno);
				try(ResultSet rs=ps.executeQuery()){
					//process the result set object
					
					if(rs.next()) {
						pw.println("<h1 style='color:blue;text-align:center;'>"+eno+" Employee Details are</h1>");
						pw.println("<div style='color:green;text-align:center'><br><b>Employee No: "+rs.getInt(1)+"</b>");
						pw.println("<br><b> Emp name: "+rs.getString(2)+"</b>");
						pw.println("<br><b>Emp Desg:  "+rs.getString(3)+"</b>");
						pw.println("<br><b>Emp Salary: "+rs.getFloat(4)+"</b>");
						pw.println("<br><b>Emp Dept No: "+rs.getInt(5)+"</b></div>");
					}else {
						pw.println("<br><h1 style='color:blue;text-align:center;'>Record Not Found...</h1>");
					}
					//add home hyperlink
					
					pw.println("<br><h3><a href='input.html'>home</h3>");
					
					
				}//try3
				
			}//try2
		
			
			
			
		}//try1
		
		catch(SQLException se) {
			se.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
