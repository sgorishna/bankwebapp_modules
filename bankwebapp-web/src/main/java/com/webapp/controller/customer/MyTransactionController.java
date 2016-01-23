package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.TransactionServiceImpl;

@WebServlet("/customer/myTransactions.php")
public class MyTransactionController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer c = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		long idCustomer = c.getIdCustomer();

		request.setAttribute("transactions", transactionService.findByIdCustomer(idCustomer));

		gotoToJSP("customer/transactionHistory.jsp", request, response);

	}
}
