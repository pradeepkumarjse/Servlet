package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet {
	private static final String GET_JSPHOTOPATH_BY_JSID="SELECT JSPHOTOPATH FROM JOBSEEKER_DETAILS WHERE JSID=?";
	private static final String GET_JSRESUMEPATH_BY_JSID="SELECT JSRESUMEPATH FROM JOBSEEKER_DETAILS WHERE JSID=?";
	
	
	
	@Resource(name="DsJndi")
	private DataSource ds;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//read additional request param value
		int id=Integer.parseInt(req.getParameter("id"));
		String type=req.getParameter("type");
		String query=null;
		if(type.equalsIgnoreCase("photo"))
			query=GET_JSPHOTOPATH_BY_JSID;
		else
			query=GET_JSRESUMEPATH_BY_JSID;
		
		//get the location of the file to be downloaded from db software
		
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				String filelocation=null;
				if(rs.next()) 
					filelocation=rs.getString(1);
				
				
				
				//perform file downoading activity
				
				//create java.io.File class obj holding filename and loaction
				File file=new File(filelocation);
				
				//get the length of file  and make response content length
				res.setContentLengthLong(file.length());
				
				//get MIME type of the file and make it as response content type
				ServletContext sc=getServletContext();
				String mimeType=sc.getMimeType(filelocation);
				
				mimeType=mimeType!=null?mimeType:"application/octet-stream";
				
				res.setContentType(mimeType);
				
				//create input stream pointing to the file to be downloaded
				InputStream is=new FileInputStream(file);
				
				
				//get output straem pointing to response object
				
				ServletOutputStream sos=res.getOutputStream();
				
				//give instruction to browser to make received content as downloadable file
				
				res.setHeader("Content-Disposition","attachment;fileName="+file.getName());				
				
				//copy content  from file to response obj using stream
				IOUtils.copy(is, sos);
				
				//close stream
				is.close();
				sos.close();
				
			}//try2
			
		}//try1
		
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("problem with db operations");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("unknown problem");
		}
		
			
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
