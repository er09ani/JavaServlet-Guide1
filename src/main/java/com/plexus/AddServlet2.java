package com.plexus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet2 extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int ans = i + j;
		System.out.println("Adding: " + i + " +"+ j + " = " + ans);
		
		Cookie cookie = new Cookie("k", ans + "");

		resp.addCookie(cookie);
		
		resp.sendRedirect("sq1");
		
	}
	
}
