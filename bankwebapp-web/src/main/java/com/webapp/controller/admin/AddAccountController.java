package com.webapp.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.services.AccountService;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;

@WebServlet("/admin/addAccount.php")
public class AddAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = customerService.findById(IdCustomer);
		request.setAttribute("customer", customer);

		gotoToJSP("admin/addAccount.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Account account = new Account();

		account.setIdCustomer(Long.parseLong(request.getParameter("IdCustomer")));
		
		account.setIdAccountType(Long.parseLong(request.getParameter("accountType")));
		account.setIdCurrency(Long.parseLong(request.getParameter("currency")));
		account.setAccountNumber(request.getParameter("accountNumber"));
		account.setBalance(new BigDecimal(0.0));

		accountService.create(account);
		request.setAttribute("accounts", accountService.getAccountByIdCustomer(account.getIdCustomer()));
		redirectRequest("/admin/accountList.php?IdCustomer=" + account.getIdCustomer(), request, response);

	}

}
