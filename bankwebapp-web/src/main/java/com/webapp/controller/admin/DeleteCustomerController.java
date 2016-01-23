package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

public class DeleteCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();
		customer = customerService.findById(Long.parseLong(request.getParameter("IdCustomer")));

		customerService.delete(customer);

		redirectRequest("/admin/customerList.php", request, response);
	}

}
