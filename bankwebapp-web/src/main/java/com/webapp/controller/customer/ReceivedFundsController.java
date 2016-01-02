package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;
import com.webapp.model.Customer;

@WebServlet("/customer/receivedFunds.php")
public class ReceivedFundsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Customer current = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		
		String idAccount = request.getParameter("IdAccount");
		
		long idCustomer = getCustomerService().findIdCustomerByIdAccount(Long.parseLong(idAccount));
		
		if(idCustomer == current.getIdCustomer()){
		
		
		request.setAttribute("transactions", getTransactionService()
				.receivedFundsByIdAccount(Long.parseLong(idAccount)));
		request.setAttribute("Received", "Received");
		
			
		Account a = getAdminService().findById(Long.parseLong(idAccount));

			request.setAttribute("idCustomer", a.getIdCustomer());

			gotoToJSP("customer/transactions.jsp", request, response);
		
		}else{
			
			redirectRequest("/customer/transactions.php", request, response);
		}
		}
}
