package com.webapp.controller.customer;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.model.Account;
import com.webapp.services.AccountService;
import com.webapp.services.CustomerService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;
import com.webapp.utils.SecurityUtills;

@WebServlet("/customer/transactionsForAccount.php")
public class TransactionByIdAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String idAccount = request.getParameter("IdAccount");

	
		boolean result = SecurityUtills.iskRequestedIdAccEqualCurrentIdCustomer(request, customerService, idAccount);

		if (result == true) {

			request.setAttribute("transactions",transactionService
					.findByIdAccount(Long.parseLong(idAccount)));
			request.setAttribute("AllByIdAcc", "AllByIdAcc");

			Account a = accountService.findById(Long.parseLong(idAccount));

			gotoToJSP("customer/transactions.jsp", request, response);
		} else {

			redirectRequest("/customer/transactions.php", request, response);
		}
	}
}
