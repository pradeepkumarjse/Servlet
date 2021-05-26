package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimingCheckingFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TimingCheckingFilter.doFilter()");
		
		//system date and time
		LocalDateTime sysDate=LocalDateTime.now();
		//get current hour of the day
		int hour=sysDate.getHour();
		if(hour<8 || hour>23) {
			//get PrintWriter
			PrintWriter pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			pw.println("<h1 style='color:red;text-align:center;'>Request must be given between 9 to 5</h1>");
			
			pw.close();
			return;
			
		}else {
			System.out.println("TimingCheckingFilter.before doFilter()");
			chain.doFilter(req, res);
			System.out.println("TimingCheckingFilter.after doFilter()");
			
		}//else
		
		
	}//dofilter(-,-)

}//class
