package com.webapp.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;
import com.webapp.model.Transaction;

@WebServlet("/admin/topUp.php")
public class TopUpController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		
		Account a = getAdminService().findById(idAccount);
			request.setAttribute("account", a);
			
			gotoToJSP("admin/topUp.jsp", request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Long idAccount = Long.parseLong(req.getParameter("IdAccount"));
		String comments = req.getParameter("comment");
		
		Account a = getAdminService().findById(idAccount);
		
		BigDecimal amount = new BigDecimal(req.getParameter("amount"));
		
		Transaction transaction = new Transaction();
		
		transaction.setAmount(amount);
		transaction.setIdAccountReceiver(idAccount);
		transaction.setReceiverAccountNumber(a.getAccountNumber());
		transaction.setReceiverName(a.getCustomerName());
		transaction.setSenderAccountNumber("MyBank");
		transaction.setCurrency(a.getCurrency());
		transaction.setSenderName("Top up service");
		
		transaction.setComments(comments);
		
		getTransactionService().topUpBalance(transaction);
		
		req.setAttribute("success", "Top up  successfull");
		doGet(req, resp);
		
		
	}

}
