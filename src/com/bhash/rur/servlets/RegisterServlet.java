package com.bhash.rur.servlets; 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhash.rur.auth.ConfirmationEmail;
import com.bhash.rur.bean.Student;





public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2446232395157555447L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");		
        String indexNum = request.getParameter("indexNum");
        String field = request.getParameter("field");
        String password = request.getParameter("password");
        String rePass = request.getParameter("rePassword");
        String email = request.getParameter("email");
        String mobile = request.getParameter("phone1");
        String landline= request.getParameter("phone2"); 
        
        Student student  = new Student();
        student.setIndex(indexNum);
        student.seteMail(email);
        student.setField(field);
        student.setFirstName(firstName);
        student.setLastName(lastName );
        student.setField(field);
        student.setLandline(landline);
        student.setMobile(mobile);
        student.setPassword(password);	
        
        PrintWriter pw = response.getWriter();
        
        if(Student.findByIndex(indexNum) == null && password.equals(rePass)){
        	
        	student.save();
        	// request.getRequestDispatcher("/UploadServlet").forward(request, response);
           HttpSession session = request.getSession();
        	session.setAttribute("indexNum", indexNum);
        	
        	ConfirmationEmail ce = new ConfirmationEmail();
			ce.sendMail(student.getIndex(), student.getFirstName() + " " + student.getLastName() );
        	response.sendRedirect("/Upload");
        	pw.print("Successfully Registered");
        	
        	
        }else{        	
        	pw.print("Already Registered");
        	
        }
        
        
        
    /*   StudentDataPersistor std = new StudentDataPersistor();
        boolean insertSuccess  = true;
        try {
			std.inserStudent(student);
			ConfirmationEmail ce = new ConfirmationEmail();
			ce.sendMail(student.getIndex(), student.getFirstName() + " " + student.getLastName() );
		
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			insertSuccess = false;
		}
        
        if(insertSuccess){
        	String statusMsg = "Registration Succeeded.Email is sent to  your webmail account. (" + student.getIndex() + "@uom.lk" + ") Please Confirm your identity  to continue"; 
        	request.setAttribute("message", statusMsg);
        	
          	request.getRequestDispatcher("RegistrationStatus.jsp").forward(request, response);
        
        }else{
       	String statusMsg = "Registration Failed"; 
       	request.setAttribute("message", statusMsg);
       	request.getRequestDispatcher("RegistrationStatus.jsp").forward(request, response);
       // response.sendRedirect("RegistrationStatus.jsp");
        }*/
        
        
	}
	
	

}
