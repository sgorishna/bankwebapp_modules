package com.webapp.actions;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class AbstractServletHandler extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	
	

	protected final void gotoToJSP(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/recources/JSP/" + page).forward(request, response);
	}

	protected final void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

}
