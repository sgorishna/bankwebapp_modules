package com.webapp.actions;



import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;

import com.webapp.utils.ImageLoadHelper;

@WebServlet("/image")
public class ImageController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String applicationPath = req.getServletContext().getRealPath("");
		String uploadPhotoPath = applicationPath + File.separator + "recources" + File.separator + "images";
		
		if(req.getParameter("main")!=null){
		File img = new File(uploadPhotoPath + File.separator + "logo_tr.png");

			ImageLoadHelper.loadImageFromFile(img, resp);
			
		}

		
		else{
			File img = new File(uploadPhotoPath + File.separator + "logo.png");

				ImageLoadHelper.loadImageFromFile(img, resp);
			
		}
	}}
