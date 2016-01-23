package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.AccountService;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;


@WebServlet("/admin/activateProfile")
public class ActivateProfileController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	AccountService service = new AccountServiceImpl(new AccountDaoImpl());
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Long idCustomer = Long.parseLong(request.getParameter("idCustomer"));

		
		Customer c = customerService.findById(idCustomer);
		
		if(c.getHash() !=null){
			
			customerService.clearHash(idCustomer);
		}
		
		
		customerService.activateProfile(idCustomer);

		redirectRequest("/admin/customerList.php",
				request, response);
	}

}
