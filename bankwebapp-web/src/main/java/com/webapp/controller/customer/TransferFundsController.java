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

		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		String comments = request.getParameter("comment");
		String senderAccountNumber = request.getParameter("sender");
		String receiverAccountNumber = request.getParameter("receiver");
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		
		Account senderAcc = getAdminService().findById(idAccount);
		Account receiverAcc = getAdminService().findByAccountNumber(receiverAccountNumber);
		
		
		Transaction transaction = new Transaction();
		
		transaction.setAmount(amount);
		transaction.setIdAccountReceiver(receiverAcc.getIdAccount());
		transaction.setReceiverAccountNumber(receiverAcc.getAccountNumber());
		transaction.setReceiverName(receiverAcc.getCustomerName());
		transaction.setSenderAccountNumber(senderAccountNumber);
		transaction.setCurrency(receiverAcc.getCurrency());
		transaction.setSenderName(senderAcc.getCustomerName());
		
		transaction.setComments(comments);
		
		getTransactionService().transferFunds(transaction);;
		
		request.setAttribute("success", "Transfer successfull");
		doGet(request, response);
	}
}
