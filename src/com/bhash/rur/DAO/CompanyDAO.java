package com.bhash.rur.DAO;

import java.util.ArrayList;
import java.util.List;

import com.bhash.rur.bean.Company;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class CompanyDAO extends DAOBase{
	
	  public Company save(Company company) {
	        ofy().put(company);	        
	        return company;
	    }
	  
	  public ArrayList<Company> getAllCompanies() {
		  Objectify ofy = ObjectifyService.begin();
          Iterable<Key<Company>> keys =   ofy.query(Company.class).fetchKeys();
          return new ArrayList<Company>(ofy.get(keys).values());
		  
	  }
	    
	  
	  public void delete(String id) {
		    Company comp = findById(id);     
	        ofy().delete(comp);
	    }
	    
	    public Company findById(String id) {
	        Key<Company> key = new Key<Company>(Company.class, id);
	        return ofy().get(key);
	    }

}
