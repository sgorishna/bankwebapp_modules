package com.webapp.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

@WebServlet("/checkEmail")
public class CheckEmailAvailabilityController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService service = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");

		Customer с = service.findByEmail(email);

		if (с.getLogin() != null) {

			request.setAttribute("taken", "Email already exists in system");
		} else {
			request.setAttribute("available", "Available");
		}

		gotoToJSP("admin/check.jsp", request, response);
	}

}
