package com.webapp.controller.customer;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;

import com.webapp.utils.SecurityUtills;

@WebServlet("/customer/transactionsForAccount.php")
public class TransactionByIdAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String idAccount = request.getParameter("IdAccount");

	
		boolean result = SecurityUtills.iskRequestedIdAccEqualCurrentIdCustomer(request, getCustomerService(), idAccount);

		if (result == true) {

			request.setAttribute("transactions", getTransactionService()
					.findByIdAccount(Long.parseLong(idAccount)));
			request.setAttribute("AllByIdAcc", "AllByIdAcc");

			Account a = getAdminService().findById(Long.parseLong(idAccount));

			gotoToJSP("customer/transactions.jsp", request, response);
		} else {

			redirectRequest("/customer/transactions.php", request, response);
		}
	}
}
