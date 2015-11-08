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

		String selectedRoles[] = request.getParameterValues("role");
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));
		customer.setEmail(request.getParameter("email"));

		try {
			getAdminService().create(customer, selectedRoles);
			SendRegistrationMail.generateAndSendEmail(request.getParameter("email"), request.getParameter("login"), request.getParameter("password"));
		} catch (InvalidDataException e) {

			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
		} catch (AddressException e) {
			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
			e.printStackTrace();
		} catch (MessagingException e) {
			Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
			e.printStackTrace();
		}

		redirectRequest("/admin/customerList.php", request, response);

	}

}
