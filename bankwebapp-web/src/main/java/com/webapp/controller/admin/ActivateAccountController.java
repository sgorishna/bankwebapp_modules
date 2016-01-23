package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Account;
import com.webapp.services.AccountService;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;

@WebServlet("/admin/activateAccount")
public class ActivateAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService service = new AccountServiceImpl(new AccountDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Long idAccount = Long.parseLong(request.getParameter("idAccount"));

		
		Account a = service.findById(idAccount);

		Long idCustomer = a.getIdCustomer();

		service.activateAccount(idAccount);

		redirectRequest("/admin/accountList.php?IdCustomer=" + idCustomer,
				request, response);
	}

}
