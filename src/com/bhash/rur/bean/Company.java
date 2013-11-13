package com.bhash.rur.bean;

import java.util.ArrayList;

import javax.persistence.Id;

public class Company {
	
	@Id
	private String companyId ;
	
	private String name;
	private String shortName;
	private String description;
	private String photo;
	private ArrayList<String> fields;
	
	
	public String getIndex() {
		return companyId;
	}
	public String getName() {
		return name;
	}
	public String getShortName() {
		return shortName;
	}
	public String getDescription() {
		return description;
	}
	public String getPhoto() {
		return photo;
	}
	public ArrayList<String> getFields() {
		return fields;
	}
	
	
	
	
	
	
	

}
