package com.webapp.controller.admin;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;


@WebServlet("/admin/transactions.php")
public class TransactionController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(request.getParameter("IdAccount") != null){
			String idAccount = request.getParameter("IdAccount");
		
			request.setAttribute("transactions", getTransactionService().findByIdAccount(Long.parseLong(idAccount)));
			request.setAttribute("all", "yes");
			gotoToJSP("admin/transactions.jsp", request, response);
			
		}
		
		
		else if (request.getParameter("All") != null) {
			String idCustomer = request.getParameter("IdCustomer");
			request.setAttribute("transactions", getTransactionService().findByIdCustomer(Long.parseLong(idCustomer)));
			request.setAttribute("all", "yes");
			gotoToJSP("admin/transactions.jsp", request, response);
		} else{
			String idCustomer = request.getParameter("IdCustomer");
		request.setAttribute("accounts", getCommonService().getAccountByIdCustomer(Long.parseLong(idCustomer)));
		
		request.setAttribute("idCustomer", idCustomer.toString());

		gotoToJSP("admin/transactions.jsp", request, response);
		}
	}
}
