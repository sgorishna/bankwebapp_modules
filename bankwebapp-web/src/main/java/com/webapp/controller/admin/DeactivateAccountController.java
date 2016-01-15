package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;

@WebServlet("/admin/deactivateAccount")
public class DeactivateAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Long idAccount = Long.parseLong(request.getParameter("idAccount"));
		
		Account a = getAdminService().findById(idAccount);
		
		Long idCustomer= a.getIdCustomer();
		
		getAdminService().deactivateAccount(idAccount);
		
		
		redirectRequest(
				"/admin/accountList.php?IdCustomer="
						+idCustomer ,
				request, response);
	}

}
