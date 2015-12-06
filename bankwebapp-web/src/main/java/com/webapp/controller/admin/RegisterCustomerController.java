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
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;

public class RegisterCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

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

		try {
			getAdminService().create(customer);
			SendRegistrationMail.generateAndSendEmail(request.getParameter("email"), request.getParameter("login"), request.getParameter("password"));
			gotoToJSP("admin/registrationResult.jsp", request, response);
		} catch (InvalidDataException e) {

			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
			// request.setAttribute("error", e.getMessage().toString());
		} catch (AddressException e) {
			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
			// request.setAttribute("error", e.getMessage().toString());
		} catch (MessagingException e) {
			Customer c = getAdminService().findByLogin(request.getParameter("login"));
			getAdminService().delete(c);
			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
			request.setAttribute("error", "Invalid email addess");
			gotoToJSP("admin/registrationResult.jsp", request, response);
		} catch (Exception e) {
			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
			request.setAttribute("error", "Something wrong, please try again");
			gotoToJSP("admin/registrationResult.jsp", request, response);

		}

	}
}
