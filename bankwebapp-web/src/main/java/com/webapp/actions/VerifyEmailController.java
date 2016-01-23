package com.webapp.actions;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.controller.admin.RegisterCustomerController;
import com.webapp.controller.admin.SendRegistrationMail;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;
import com.webapp.services.AdminService;
import com.webapp.services.CustomerService;

import com.webapp.services.Impl.CustomerServiceImpl;
import com.webapp.utils.SecurityUtills;

@WebServlet("/verify")
public class VerifyEmailController extends AbstractServletHandler {

	static Logger log = Logger.getLogger(VerifyEmailController.class.getName());

	private static final long serialVersionUID = 1L;
	
	CustomerService service = new CustomerServiceImpl(new CustomerDaoImpl());
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");

		String hash = request.getParameter("hash");

		Customer c = service.findByLogin(login);
		long idCustomer = c.getIdCustomer();

		if (c.getHash() != null) {

			boolean result = SecurityUtills.compareCredentials(c, login, hash);

			if (result == true) {

				service.activateProfile(c.getIdCustomer());

			service.clearHash(idCustomer);
				request.setAttribute("success", "Your account has been verified ");
				gotoToJSP("verify.jsp", request, response);
			} else {
				request.setAttribute("error", "Invalid credentials ");
				gotoToJSP("verify.jsp", request, response);
			}
		} else {

			request.setAttribute("error", "Account is already verified or does not exist");
			gotoToJSP("verify.jsp", request, response);
		}

	
	}

}
