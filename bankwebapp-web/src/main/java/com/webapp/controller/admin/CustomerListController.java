package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

@WebServlet("/admin/customerList.php")
public class CustomerListController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("customers", customerService.findAll());

		gotoToJSP("admin/customerList.jsp", request, response);
	}

}
