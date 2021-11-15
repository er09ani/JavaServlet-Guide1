package com.plexus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet1 extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int ans = i + j;
		System.out.println("Adding: " + i + " +"+ j + " = " + ans);
		HttpSession session = req.getSession();
		
		session.setAttribute("k", ans);
		// two ways to call a servlet from servlet
		// 1. Request Dispatcher
		// 2. Redirect
		
		
		// when we want to share data from one servlet to another servlet
				// we use session management
				
				// easy way is to put data in req object by set attribute
//		req.setAttribute("ans", ans);
//		RequestDispatcher rd = req.getRequestDispatcher("sq");//  enter url
//		rd.forward(req, resp);
		
		resp.sendRedirect("sq?k=" + ans); // 1. URL rewriting
		//2. session management
		//3. cookies
		// if you want to let knowclient that u r
		// getting redirected to another url...
		// use method sendRedirect()
		
		
		
		
		
		
		
		
		PrintWriter out = resp.getWriter();
		
		out.println("Result is "+ ans);
		
	}
	
}
