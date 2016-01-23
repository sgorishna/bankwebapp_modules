package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;

import com.webapp.services.AccountService;

import com.webapp.services.Impl.AccountServiceImpl;


@WebServlet("/admin/accountList.php")
public class AccountListController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService service = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("IdCustomer") != null) {
			long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
			request.setAttribute("accounts", service.getAccountByIdCustomer(IdCustomer));
			request.setAttribute("idCustomer", IdCustomer);
			gotoToJSP("admin/customerAccountList.jsp", request, response);
		} else {
			request.setAttribute("accounts", service.findAllAccounts());
			gotoToJSP("admin/accountList.jsp", request, response);
		}

	}

}
