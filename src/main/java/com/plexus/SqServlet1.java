package com.plexus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet1 extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//		int k = (int) req.getAttribute("ans");
//		k = k * k;
//		
//		PrintWriter out = resp.getWriter();
//		
//		out.println("Message from SqServlet: Result is : " + k );

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Cookie[] cookies = req.getCookies();
		int k = -1;
		for(Cookie c : cookies) {
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}

		PrintWriter out = resp.getWriter();

		out.println("Message from SqServlet: Result is : " + k);

	}
}
