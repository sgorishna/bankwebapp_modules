package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.AccountService;
import com.webapp.services.Impl.AccountServiceImpl;

@WebServlet("/customer/myAccounts.php")
public class MyAccountsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer c = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		long idCustomer = c.getIdCustomer();

		request.setAttribute("accounts", accountService.getAccountByIdCustomer(idCustomer));

		gotoToJSP("customer/myAccounts.jsp", request, response);

	}
}
