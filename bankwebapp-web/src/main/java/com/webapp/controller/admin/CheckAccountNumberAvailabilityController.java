package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;
import com.webapp.model.Customer;

@WebServlet("/admin/checkAccountNumber")
public class CheckAccountNumberAvailabilityController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String an = request.getParameter("accountNumber");
		
		if(an == ""){
			
			request.setAttribute("available", "Available");
		} else{
		
		Long accountNumber = Long.parseLong(an);

		Account a = getAdminService().getAccountByAccountNumber(accountNumber);

		if (a.getCreated() != null ) {

			request.setAttribute("taken", "Account number already exists in system");
		} else {
			request.setAttribute("available", "Available");
		}
		}

		gotoToJSP("admin/check.jsp", request, response);
	}

}
