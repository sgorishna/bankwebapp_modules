package com.webapp.controller.admin;

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

@WebServlet("/admin/transactions.php")
public class TransactionController extends AbstractServletHandler {

	
TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {


	if (request.getParameter("All") != null) {
		String idCustomer = request.getParameter("IdCustomer");
		request.setAttribute("transactions", transactionService
				.findByIdCustomer(Long.parseLong(idCustomer)));
		request.setAttribute("all", "yes");
		request.setAttribute("idCustomer", idCustomer);
		gotoToJSP("admin/transactions.jsp", request, response);
	} else {
		String idCustomer = request.getParameter("IdCustomer");
		request.setAttribute("accounts", accountService
				.getAccountByIdCustomer(Long.parseLong(idCustomer)));

		request.setAttribute("idCustomer", idCustomer.toString());

		gotoToJSP("admin/transactions.jsp", request, response);
	}
}}