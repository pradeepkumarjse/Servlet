package com.nt.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/marriageurl")
public class PerformanceTestFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("PerformanceTestFilter: before doFilter()");
		
		long start=0,end=0;
		//get request trappping time
		start=System.currentTimeMillis();//request processing logic
		chain.doFilter(req, res);
		//get responnse trapping time
		end=System.currentTimeMillis();//response processing logic
		System.out.println(req.getRequestURI()+"has taken.."+(end-start)+"ms to process the request");
		System.out.println("PerformanceTestFilter: after doFilter()");
		
	}

}
