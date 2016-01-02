package com.webapp.controller.customer;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;
import com.webapp.model.Transaction;

@WebServlet("/customer/transferFunds.php")
public class TransferFundsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String idAccount = request.getParameter("IdAccount");
		
		Account a = getAdminService().findById(Long.parseLong(idAccount));
		
		 request.setAttribute("accountNumber", a.getAccountNumber());
		 
		 request.setAttribute("account", a);
		gotoToJSP("customer/transferFunds3.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Transaction transaction = new Transaction();
		String senderAccountNumber = request.getParameter("senderAccountNumber");
		String receiverAccountNumber =request.getParameter("receiverAccountNumber");

		BigDecimal amount = new BigDecimal(request.getParameter("amount"));

		Account sender = getTransactionService().findByAccountNumber(senderAccountNumber);
		Account receiver = getTransactionService().findByAccountNumber(receiverAccountNumber);

		transaction.setIdAccountSender(sender.getIdAccount());
		transaction.setIdAccountReceiver(receiver.getIdAccount());
		transaction.setComments(request.getParameter("comments"));
		transaction.setSenderAccountNumber(senderAccountNumber);
		transaction.setReceiverAccountNumber(receiverAccountNumber);
		transaction.setAmount(amount);

		getTransactionService().create(transaction);

		redirectRequest("/customer/myAccounts.php", request, response);
	}
}
