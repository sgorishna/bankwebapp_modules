package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

@WebServlet("/admin/profile.php")
public class CustomerProfileController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idCustomer  =  Long.parseLong(request.getParameter("IdCustomer"));
		
		Customer customer = customerService.findById(idCustomer);
		
		request.setAttribute("customer", customer);

		gotoToJSP("admin/customerProfile.jsp", request, response);
	}

}
