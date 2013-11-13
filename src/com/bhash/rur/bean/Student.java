package com.bhash.rur.bean;

import javax.persistence.Id;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import java.net.URI;
import java.util.ArrayList;




public class Student {
	
	@Id
	private String index ;
	
	private String firstName;
	private String lastName;
	private String eMail;
	private String field;
	private String password;
	private String mobile;
	private String landline;
	private String resumeId;
	private boolean activated ;
	private URI uri; 
	private ArrayList<String> companies;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student(String index, String firstName, String lastName,
			String eMail, String field, String password, String mobile,
			String landline, String title, boolean activated, URI uri) {
		super();
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.field = field;
		this.password = password;
		this.mobile = mobile;
		this.landline = landline;
		this.resumeId = title;
		this.activated = activated;
		this.uri = uri;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getTitle() {
		return resumeId;
	}
	public void setTitle(String title) {
		this.resumeId = title;		
	}

	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	
	 private static Objectify getService() {
		  return ObjectifyService.begin();
		 }

		 public static Student findByIndex(String index) {
			try{
				 Objectify service = getService();
				 return service.get(Student.class, index);
				
			}catch(Exception e){
				 return null;
			}
		 
		 }
		 
		 public void addResume(Resume resume){
			 resume.setOwner(this);
			 Objectify service = getService();
			 service.put(resume);
			}
		 
		 public void save(){
			
			 Objectify service = getService();
			 service.put(this);
			}
}

