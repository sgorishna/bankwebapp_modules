package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;

@WebServlet("/admin/transferredFunds.php")
public class TransferredFundsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String idAccount = request.getParameter("IdAccount");

		request.setAttribute("transactions", getTransactionService()
				.transferredFundsByIdAccount(Long.parseLong(idAccount)));
		request.setAttribute("Transferred", "Transferred");
		
			
		Account a = getAdminService().findById(Long.parseLong(idAccount));

			request.setAttribute("idCustomer", a.getIdCustomer());

			gotoToJSP("admin/transactions.jsp", request, response);
		}
}
