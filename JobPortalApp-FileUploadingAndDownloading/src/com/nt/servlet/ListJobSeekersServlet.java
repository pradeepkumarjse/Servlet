package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/list_jsurl")
public class ListJobSeekersServlet extends HttpServlet {
	private static final String GET_ALL_JOBSEEKER="SELECT JSID,JSNAME,JSADDRESS,JSPHOTOPATH,JSRESUMEPATH FROM JOBSEEKER_DETAILS";
	
	@Resource(name="DsJndi")
	private DataSource ds;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set resp content type
		res.setContentType("text/html");
		
		//get pooled jdbc connection
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(GET_ALL_JOBSEEKER)){
				try(ResultSet rs=ps.executeQuery()){
					
					pw.println("<table border='1' align='center' bgcolor='cyan'");
					pw.println("<tr><th>JSID</th><th>JSNAME</th><th>JSADDRESS</th><th>PHOTO</th><th>RESUME</h1></tr>");
					while(rs.next()) {
						pw.println("<tr>");
						pw.println("<td>"+rs.getInt(1)+"</td>");
						pw.println("<td>"+rs.getString(2)+"</td>");
						pw.println("<td>"+rs.getString(3)+"</td>");
						pw.println("<td><a href='downloadurl?id="+rs.getInt(1)+"&type=photo'>Download</a></td>");
						pw.println("<td><a href='downloadurl?id="+rs.getInt(1)+"&type=resume'>Download</a></td>");
						pw.println("</tr>");
						
					}//while
					
					pw.println("</table>");
					
					
				}//try 2
			}//try 1
			
			
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("problem in DB Operations");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		pw.println("<h1 style='text-align:center;'><a href='index.html'>Home</a></h1>");
		//close stream
		pw.close();
		
		
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req,res);
		
	}

}
