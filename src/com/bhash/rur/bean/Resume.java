package com.bhash.rur.bean;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Id;

import com.googlecode.objectify.Key;





public class Resume {
	
	@Id
	private Long id;
	private String title;
	private String  studentId;
	private Time uploadTime; 
	
    private byte[] resumeData;
    private String resumePath;
    
    private Key<Student> owner; 
    
    public Resume() {
		// TODO Auto-generated constructor stub
	}
	
  public Resume(String title, String studentId ) {
	 this.title = title;
	 this.studentId = studentId;
}

public void setId(Long id) {
	this.id = id;
}

public void setTitle(String title) {
	this.title = title;
}

public void setStudentId(String studentId) {
	this.studentId = studentId;
}

public void setUploadTime(Time uploadTime) {
	this.uploadTime = uploadTime;
}

public void setResumeData(byte[] resumeData) {
	this.resumeData = resumeData;
}

public void setResumePath(String resumePath) {
	this.resumePath = resumePath;
}

public Long getId() {
	return id;
}

public String getTitle() {
	return title;
}

public String getStudentId() {
	return studentId;
}

public Time getUploadTime() {
	return uploadTime;
}

public byte[] getResumeData() {
	return resumeData;
}

public String getResumePath() {
	return resumePath;
}
 
public void setOwner(Student owner) {
	  this.owner = new Key<Student>(Student.class, owner.getIndex());
	 }
  
 
	

}
