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
import com.webapp.services.AccountService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;

@WebServlet("/admin/transactionsForAccount.php")
public class TransactionByIdAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
			String idAccount = request.getParameter("IdAccount");

			request.setAttribute("transactions", transactionService
					.findByIdAccount(Long.parseLong(idAccount)));
			request.setAttribute("AllByIdAcc", "AllByIdAcc");
			
		Account a = accountService.findById(Long.parseLong(idAccount));

			request.setAttribute("idCustomer", a.getIdCustomer());

			gotoToJSP("admin/transactions.jsp", request, response);
		}
}
