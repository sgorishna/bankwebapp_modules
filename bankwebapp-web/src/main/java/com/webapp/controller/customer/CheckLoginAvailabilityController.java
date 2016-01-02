package com.webapp.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

@WebServlet("/customer/checkLogin")
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

		gotoToJSP("customer/check.jsp", request, response);
	}

}
