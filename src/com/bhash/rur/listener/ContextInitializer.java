package com.bhash.rur.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bhash.rur.bean.Resume;
import com.bhash.rur.bean.Student;
import com.googlecode.objectify.ObjectifyService;

public class ContextInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Student.class);
		ObjectifyService.register(Resume.class);
		
	}

}
