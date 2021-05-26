package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {

	
	//create write stream which takes inMemory string obj/buffer as the destination to store the written data
	CharArrayWriter writer=new CharArrayWriter();

	public MyResponse(HttpServletResponse response) {
		super(response);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter pw=new PrintWriter(writer);
		return pw;//pw.println()--> CharArrayWriter --> InMemoryString/buffer
	}
	@Override 
	public String toString() {
		return writer.toString();
	}
}
