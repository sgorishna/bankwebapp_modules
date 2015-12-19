package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

@WebServlet("/admin/checkAccountNumber")
public class CheckAccountNumberAvailabilityController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accountNumber = request.getParameter("accountNumber");

		Customer с = getCommonService().findByEmail(accountNumber);

		if (с.getLogin() != null) {

			request.setAttribute("taken", "Email already exists in system");
		} else {
			request.setAttribute("available", "Available");
		}

		gotoToJSP("admin/check.jsp", request, response);
	}

}
