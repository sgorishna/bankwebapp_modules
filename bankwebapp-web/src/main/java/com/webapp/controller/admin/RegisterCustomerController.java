package com.webapp.controller.admin;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

public class RegisterCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		gotoToJSP("admin/registerCustomer.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();

		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));
		customer.setEmail(request.getParameter("email"));
		customer.setIdRole(Integer.parseInt(request.getParameter("role")));
		customer.setActive(Integer.parseInt(request.getParameter("active")));
		customer.setHash(null);

		Customer d = customerService.findByEmail(request.getParameter("email"));

		if (customerService.findByLogin(request.getParameter("login")).getLogin() != null) {

			request.setAttribute("error", "Account with such login  exist already in system");
			gotoToJSP("admin/registrationResult.jsp", request, response);
		} else if (d.getEmail() != null) {

			request.setAttribute("error", "Account with such email  exist already in system");
			gotoToJSP("admin/registrationResult.jsp", request, response);

		} else {

			try {

				customerService.create(customer);
				SendRegistrationMail.generateAndSendEmail(request.getParameter("email"), request.getParameter("login"), request.getParameter("password"));
				gotoToJSP("admin/registrationResult.jsp", request, response);
			
			} catch (AddressException e) {
				Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);

			} catch (MessagingException e) {

				customerService.delete(customerService.findByLogin(request.getParameter("login")));
e.printStackTrace();
				Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
				request.setAttribute("error", "Invalid email addess");
				gotoToJSP("admin/registrationResult.jsp", request, response);
			}
		}
	}
}
