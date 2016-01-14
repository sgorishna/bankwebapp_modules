package com.webapp.utils;

import static com.webapp.utils.WebappConstants.UPLOAD_DIR;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public final class WebappConstants {

	public static final String CURRENT_SESSION_ACCOUNT = "CURRENT_SESSION_ACCOUNT";

	public static final String UPLOAD_DIR = "photos";

	public static final int MAX_PHOTO_SIZE = 65000;

	public static final int ROLE_ADMIN = 1;

	public static final int ROLE_CUSTOMER = 2;
	
	public static final String DEBIT = "DEBIT";
	
	public static final int ACTIVE = 1;
	
	public static final int INACTIVE= 2;
	
	public static final String applicationPath(HttpServletRequest request){
		
		return request.getServletContext().getRealPath("");
	}
	
	public static final String uploadPhotoPath (HttpServletRequest request){
		
		return applicationPath(request)+ File.separator + "recources" + File.separator + UPLOAD_DIR;
	}
}
