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
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;

@WebServlet("/RemindCredentials")
public class RemindCredentialsController extends AbstractServletHandler {

	static Logger log = Logger.getLogger(RemindCredentialsController.class.getName());

	private static final long serialVersionUID = 1L;



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		gotoToJSP("remind.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		Customer c = getCommonService().findByEmail(email);
		
		
		if(c.getEmail() != null){
			
			request.setAttribute("success",  " Success! Check mail");
			gotoToJSP("remind.jsp", request, response);
			
			try {
				SendRegistrationMail.generateAndSendEmail(request.getParameter("email"), c.getLogin(), c.getPassword());
			} catch (AddressException e) {
				Logger.getLogger(RemindCredentialsController.class.getName()).log(Level.DEBUG, null, e);
				e.printStackTrace();
			} catch (MessagingException e) {
				Logger.getLogger(RemindCredentialsController.class.getName()).log(Level.DEBUG, null, e);
				e.printStackTrace();
			}
		} else{
			request.setAttribute("error",  " Account with such email does not exist");
			gotoToJSP("remind.jsp", request, response);
			
		}
		

	}

}
