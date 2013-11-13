package com.bhash.rur.auth;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ConfirmationEmail   {
	
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props, null);

	String msgBody = "...";
	
	
	public void sendMail(String index , String userName ){
		System.out.println(index);
		try{
		  Message msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress("areyouready2013@rotaractmora.org"));
		  
		  msg.addRecipient(Message.RecipientType.TO,
		  new InternetAddress("bhathiya.11@cse.mrt.ac.lk"));
		  msg.setSubject("Confirmation Email For Are You Ready");
		  msg.setText(msgBody);
		  Transport.send(msg);
		  
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}


	
	

}
