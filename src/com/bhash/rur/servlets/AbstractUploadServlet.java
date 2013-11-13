package com.bhash.rur.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class AbstractUploadServlet extends HttpServlet{

	public abstract void showForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException;
	public abstract void handleSubmit(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException;
	public abstract void showRecord(long id , HttpServletRequest request , HttpServletResponse response)  throws IOException,ServletException;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String  action = req.getParameter("action");
		if("display".equals(action)){
	        long id = Long.parseLong(req.getParameter("id").replace("_", ""));
	        showRecord(id, req, resp);
	    } else {
	        showForm(req, resp);
	    }

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleSubmit(req, resp);
		
	}
	
	
}
