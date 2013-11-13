package com.bhash.rur.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhash.rur.bean.Student;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String password = req.getParameter("password");
		String index = req.getParameter("index");	
		
		Student std = Student.findByIndex(index);
		
		if(std !=null && std.getPassword().equals(password)  ){
			req.getSession().setAttribute("user", std);
			resp.sendRedirect("links.html");
		}
		else
			resp.sendRedirect("login.jsp?id=Invalid username and password");
	}


}
