package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;

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
import com.webapp.model.Customer;
import com.webapp.services.AccountService;
import com.webapp.services.CustomerService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;

@WebServlet("/customer/receivedFunds.php")
public class ReceivedFundsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Customer current = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		
		String idAccount = request.getParameter("IdAccount");
		
		long idCustomer = customerService.findIdCustomerByIdAccount(Long.parseLong(idAccount));
		
		if(idCustomer == current.getIdCustomer()){
		
		
		request.setAttribute("transactions", transactionService
				.receivedFundsByIdAccount(Long.parseLong(idAccount)));
		request.setAttribute("Received", "Received");
		
			
		Account a = accountService.findById(Long.parseLong(idAccount));

			request.setAttribute("idCustomer", a.getIdCustomer());

			gotoToJSP("customer/transactions.jsp", request, response);
		
		}else{
			
			redirectRequest("/customer/transactions.php", request, response);
		}
		}
}
