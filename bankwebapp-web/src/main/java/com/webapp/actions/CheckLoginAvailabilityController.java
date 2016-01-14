package com.webapp.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.model.Customer;

@WebServlet("/checkLogin")
public class CheckLoginAvailabilityController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");

		Customer с = getAdminService().findByLogin(login);

		if (с.getLogin() != null) {

			request.setAttribute("taken", "Login already taken");
		} else {
			request.setAttribute("available", "Available");
		}

		gotoToJSP("admin/check.jsp", request, response);
	}

}
