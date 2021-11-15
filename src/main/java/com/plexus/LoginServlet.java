package com.plexus;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String userId = req.getParameter("userId");
		
		String name = req.getParameter("name");
		
		ServletContext ctx = getServletContext();
		ServletConfig cfg = getServletConfig();
		String databaseUrl = ctx.getInitParameter("databaseUrl"); 
		String databaseUserName = cfg.getInitParameter("databaseUserName");
		String databaseUserPassword = cfg.getInitParameter("databaseUserPassword");
		
		try {
			Connection conn = DriverManager.getConnection(databaseUrl, databaseUserName, databaseUserPassword);

			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from employees_tbl where id=" + userId);
			while(resultSet.next()) {
				System.out.println("User exists with given userId");
				System.out.println(resultSet.getString(2));
				if(resultSet.getString("name").equals(name)) {
					resp.getWriter().println("Login Success");
				}
				else {
					resp.getWriter().println("Error authenticating User");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
