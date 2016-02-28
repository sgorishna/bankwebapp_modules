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

@WebServlet("/customer/transferFunds.php")
public class TransferFundsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	
	ExchangeRatesService ratesService =  new ExchangeRatesServiceImpl(new ExchangeRateDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idAccount = request.getParameter("IdAccount");

		boolean result = SecurityUtills
				.iskRequestedIdAccEqualCurrentIdCustomer(request,
						customerService, idAccount);

		if (result == true) {

			Account a = accountService.findById(Long.parseLong(idAccount));

			request.setAttribute("accountNumber", a.getAccountNumber());

			request.setAttribute("account", a);
			gotoToJSP("customer/transferFunds.jsp", request, response);

		} else {

			redirectRequest("/customer/myAccounts.php", request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		String comments = request.getParameter("comment");
	    String senderAccountNumber = request.getParameter("sender");
		String receiverAccountNumber = request.getParameter("receiver");
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));

		//Account senderAcc = accountService.findById(idAccount);
		Account senderAcc = accountService.findByAccountNumber(
				senderAccountNumber);
		Account receiverAcc = accountService.findByAccountNumber(
				receiverAccountNumber);

		
			

			String actype = senderAcc.getAccountType();

			int compare = amount.compareTo(senderAcc.getBalance());

			if (compare == 1) {

				if (actype.equals(DEBIT)) {

					request.setAttribute("error", "Insufficient credit");
				}
				
				//сделать перевод на страницу unsuccessfull transfer
				//doGet(request, response);

			}

			else {
				
				long senderCur = senderAcc.getIdCurrency();
				
				long receiverCur = receiverAcc.getIdCurrency();
				
				BigDecimal exchangeRate  = TransactionHelper.getExchangeRate(senderCur, receiverCur, ratesService);
				
				Transaction transaction = new Transaction();

				transaction.setAmount(amount);
				transaction.setAmountAfterConversion(amount.multiply(exchangeRate));
				transaction.setIdAccountReceiver(receiverAcc.getIdAccount());
				transaction.setReceiverAccountNumber(receiverAcc
						.getAccountNumber());
				transaction.setReceiverName(receiverAcc.getCustomerName());
				transaction.setSenderAccountNumber(senderAccountNumber);
				transaction.setCurrency(receiverAcc.getCurrency());
				transaction.setSenderName(senderAcc.getCustomerName());
				transaction.setIdAccountSender(idAccount);
				transaction.setComments(comments);

				transactionService.transferFunds(transaction);
				

				request.setAttribute("success", "Transfer successfull");
				//redirect to the success page
				doGet(request, response);
			}
		}

	
}
