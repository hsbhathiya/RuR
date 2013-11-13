package com.bhash.rur.DAO;

import com.bhash.rur.bean.Resume;
import com.googlecode.objectify.*;
import com.googlecode.objectify.util.DAOBase;

public class ResumeDAO extends DAOBase {
	
	/*static{
	  ObjectifyService.register(Resume.class);	
	}*/
	
	  public Resume save(Resume Resume) {
	        ofy().put(Resume);	        
	        return Resume;
	    }
	    
	    public Resume findById(Long id) {
	        Key<Resume> key = new Key<Resume>(Resume.class, id);
	        return ofy().get(key);
	    }

}
