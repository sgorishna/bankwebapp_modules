package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.services.AccountService;
import com.webapp.services.Impl.AccountServiceImpl;

@WebServlet("/admin/checkAccountNumber")
public class CheckAccountNumberAvailabilityController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accountNumber = request.getParameter("accountNumber");
		
		if(accountNumber == ""){
			
			request.setAttribute("available", "Available");
		} else{
		
		

		Account a = accountService.findByAccountNumber(accountNumber);

		if (a.getCreated() != null ) {

			request.setAttribute("taken", "Account number already exists in system");
		} else {
			request.setAttribute("available", "Available");
		}
		}

		gotoToJSP("admin/check.jsp", request, response);
	}

}
