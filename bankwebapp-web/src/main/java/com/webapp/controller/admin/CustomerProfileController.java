package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

@WebServlet("/admin/profile.php")
public class CustomerProfileController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idCustomer  =  Long.parseLong(request.getParameter("IdCustomer"));
		
		Customer customer = getCommonService().findById(idCustomer);
		
		request.setAttribute("customer", customer);

		gotoToJSP("admin/customerProfile.jsp", request, response);
	}

}
