package com.bhash.rur.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhash.rur.DAO.ResumeDAO;
import com.bhash.rur.bean.Resume;
import com.bhash.rur.bean.Student;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;


@SuppressWarnings("serial")
public class BlobstoreUploadServlet extends AbstractUploadServlet {
	
	 private BlobstoreService blobService = BlobstoreServiceFactory.getBlobstoreService();
     private ResumeDAO dao = new ResumeDAO();

	@Override
	public void showForm(HttpServletRequest req,
		 HttpServletResponse resp) throws ServletException, IOException {
		 String uploadUrl = blobService.createUploadUrl("/Upload");
		 req.setAttribute("uploadUrl", uploadUrl);
		 req.getRequestDispatcher("Blobstore.jsp").forward(req, resp);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void handleSubmit(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		 Map<String, BlobKey> blobs = blobService.getUploadedBlobs(req);
		    BlobKey blobKey = blobs.get(blobs.keySet().iterator().next());

		    String resumePath = blobKey.getKeyString();
		    String title = req.getParameter("title");
		    String studentId = ((Student) req.getSession().getAttribute("user")).getIndex();
		    
		   Resume resume = new Resume(title, studentId);
		   resume.setResumePath(resumePath);
		   Student std = (Student)req.getSession().getAttribute("user");
		   resume.setOwner(std);
		  // resume.setStudentId();
		    dao.save(resume);
		    resp.sendRedirect("links.html");
		   //showRecord(resume.getId(), req, resp);
		  
		 //  resp.sendRedirect("UploadServlet?action=display&id=" + resume.getId());
		
	}

	@Override
	public void showRecord(long id, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		  Resume resume = dao.findById(id);
		  String resumePath = resume.getResumePath();
		  blobService.serve(new BlobKey(resumePath), resp);
		
	}

}
