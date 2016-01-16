package com.webapp.actions;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.webapp.utils.WebappConstants.ROLE_CUSTOMER;
import static com.webapp.utils.WebappConstants.INACTIVE;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.controller.admin.RegisterCustomerController;
import com.webapp.controller.admin.SendRegistrationMail;
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;


@WebServlet("/signUp.php")
public class SignUpController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		gotoToJSP("signUp.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = new Customer();

		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));
		customer.setEmail(request.getParameter("email"));
		customer.setIdRole(ROLE_CUSTOMER);
		customer.setActive(INACTIVE);

		Customer d = getCommonService().findByEmail(request.getParameter("email"));

		if (getAdminService().findByLogin(request.getParameter("login")).getLogin() != null) {

			request.setAttribute("error", "Account with such login  exist already in system");
			doGet(request, response);
		} else if (d.getEmail() != null) {

			request.setAttribute("error", "Account with such email  exist already in system");
			doGet(request, response);

		} else {

			try {

				getAdminService().create(customer);
				SendRegistrationMail.generateAndSendEmail(request.getParameter("email"), request.getParameter("login"), request.getParameter("password"));
				gotoToJSP("regSuccess.jsp", request, response);
			} catch (InvalidDataException e) {

				Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);

			} catch (AddressException e) {
				Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);

			} catch (MessagingException e) {

				getAdminService().delete(getAdminService().findByLogin(request.getParameter("login")));
e.printStackTrace();
				Logger.getLogger(RegisterCustomerController.class.getName()).log(Level.DEBUG, null, e);
				request.setAttribute("error", "Invalid email addess");
				doGet(request, response);
			}
		}
	}

}
