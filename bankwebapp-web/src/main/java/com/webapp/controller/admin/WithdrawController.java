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

@WebServlet("/admin/withdraw.php")
public class WithdrawController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		
		Account a = getAdminService().findById(idAccount);
			request.setAttribute("account", a);
			
			gotoToJSP("admin/withdraw.jsp", request, response);
		
			//request.getSession().removeAttribute("error");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		
		
		
		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		String comments = request.getParameter("comment");
		
		Account a = getAdminService().findById(idAccount);
		
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		
	
		String actype = a.getAccountType();
	 
	int compare = amount.compareTo(a.getBalance());
	
	if(compare == 1  ){
		
		if(actype.equals("DEBIT")){
		
		request.setAttribute("error", "Insufficient credit");
		}	
		doGet(request, responce);
		
	}else{
		
		Transaction transaction = new Transaction();
		
		transaction.setAmount(amount.multiply(new BigDecimal(-1)));
		transaction.setIdAccountReceiver(idAccount);
		transaction.setReceiverAccountNumber(a.getAccountNumber());
		transaction.setSenderAccountNumber("MyBank withdraw service");
		transaction.setComments(comments);
		
		getTransactionService().withdrawBalance(transaction);
		
		
		request.setAttribute("success", "Withdraw successfull");
		doGet(request, responce);
	}	
		
	}

}
