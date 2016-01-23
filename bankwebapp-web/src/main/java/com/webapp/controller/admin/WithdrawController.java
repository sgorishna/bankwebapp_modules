package com.webapp.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Transaction;
import com.webapp.services.AccountService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;

import static com.webapp.utils.WebappConstants.DEBIT;

@WebServlet("/admin/withdraw.php")
public class WithdrawController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
	TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoImpl());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		
		Account a = accountService.findById(idAccount);
			request.setAttribute("account", a);
			
			gotoToJSP("admin/withdraw.jsp", request, response);
		
			//request.getSession().removeAttribute("error");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		
		
		
		Long idAccount = Long.parseLong(request.getParameter("IdAccount"));
		String comments = request.getParameter("comment");
		
		Account a = accountService.findById(idAccount);
		
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		
	
		String actype = a.getAccountType();
	 
	int compare = amount.compareTo(a.getBalance());
	
	if(compare == 1  ){
		
		if(actype.equals(DEBIT)){
		
		request.setAttribute("error", "Insufficient credit");
		}	
		doGet(request, responce);
		
	}else{
		
		Transaction transaction = new Transaction();
		
		transaction.setAmount(amount.multiply(new BigDecimal(-1)));
		transaction.setIdAccountReceiver(idAccount);
		transaction.setReceiverAccountNumber(a.getAccountNumber());
		transaction.setReceiverName(a.getCustomerName());
		transaction.setSenderAccountNumber("MyBank");
		transaction.setSenderName("Withdraw service");
		transaction.setCurrency(a.getCurrency());
		transaction.setComments(comments);
		
		transactionService.withdrawBalance(transaction);
		
		
		request.setAttribute("success", "Withdraw successfull");
		doGet(request, responce);
	}	
		
	}

}
