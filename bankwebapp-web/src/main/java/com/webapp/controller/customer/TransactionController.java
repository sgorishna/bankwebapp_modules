package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.services.AccountService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;

@WebServlet("/customer/transactions.php")
public class TransactionController extends AbstractServletHandler {

	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());	
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

	Customer c = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
	long idCustomer = c.getIdCustomer();

	if (request.getParameter("All") != null) {
		
		request.setAttribute("transactions", transactionService
				.findByIdCustomer(idCustomer));
		request.setAttribute("all", "yes");
		
		gotoToJSP("customer/transactions.jsp", request, response);
	} else {
	
		request.setAttribute("accounts", accountService
				.getAccountByIdCustomer(idCustomer));

		

		gotoToJSP("customer/transactions.jsp", request, response);
	}
}}