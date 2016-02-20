package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.DEBIT;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.dao.impl.ExchangeRateDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Transaction;
import com.webapp.services.AccountService;
import com.webapp.services.CustomerService;
import com.webapp.services.ExchangeRatesService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;
import com.webapp.services.Impl.ExchangeRatesServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;
import com.webapp.utils.SecurityUtills;
import com.webapp.utils.TransactionHelper;

@WebServlet("/customer/transferFundsConfirmation.php")
public class TransferFundsConfirmationController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	
	ExchangeRatesService ratesService =  new ExchangeRatesServiceImpl(new ExchangeRateDaoImpl());

	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		String comments = request.getParameter("comment");
		
		String receiverAccountNumber = request.getParameter("receiver");
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));

		Account senderAcc = accountService.findById(idAccount);
		Account receiverAcc = accountService.findByAccountNumber(
				receiverAccountNumber);

		if (receiverAcc.getAccountNumber() == null) {

			request.setAttribute("error", "Account does not exist in system");
			doGet(request, response);

		} else {

			String senderAccountNumber = senderAcc.getAccountNumber();

			String actype = senderAcc.getAccountType();

			int compare = amount.compareTo(senderAcc.getBalance());

			if (compare == 1) {

				if (actype.equals(DEBIT)) {

					request.setAttribute("error", "Insufficient credit");
				}
				doGet(request, response);

			}

			else {
				
				request.setAttribute("sender", senderAccountNumber);
				request.setAttribute("receiver", receiverAccountNumber);
				request.setAttribute("amount", amount);
				request.setAttribute("comments", comments);
				
				gotoToJSP("customer/transferFundsConfirmation.jsp", request, response);
			}
		}

	}
}
