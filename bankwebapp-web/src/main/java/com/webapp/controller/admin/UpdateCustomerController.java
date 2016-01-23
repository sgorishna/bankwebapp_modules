package com.webapp.controller.admin;

import static com.webapp.utils.WebappConstants.applicationPath;
import static com.webapp.utils.WebappConstants.UPLOAD_DIR;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

import static com.webapp.utils.WebappConstants.applicationPath;

@MultipartConfig
public class UpdateCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = customerService.findById(IdCustomer);
		request.setAttribute("customer", customer);

		
		String uploadPhotoPath =  applicationPath(request) + File.separator + "recources"
				+ File.separator + UPLOAD_DIR;
		request.setAttribute("path", uploadPhotoPath + File.separator
				+ customer.getIdCustomer() + ".JPG");

		gotoToJSP("admin/updateCustomer.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();

		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));
		customer.setEmail(request.getParameter("email"));
		customer.setActive(Integer.parseInt(request.getParameter("active")));

		customer.setIdCustomer(Long.parseLong(request
				.getParameter("IdCustomer")));

		customerService.update(customer);

		redirectRequest(
				"/admin/updateCustomer.php?IdCustomer="
						+ customer.getIdCustomer(),
				request, response);

	}
}
