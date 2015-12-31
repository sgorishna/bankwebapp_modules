package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;
import static com.webapp.utils.WebappConstants.UPLOAD_DIR;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

@MultipartConfig
@WebServlet("/customer/editProfile.php")
public class EditProfileController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

Customer customer = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		
		
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadPhotoPath = applicationPath + File.separator + "recources"
				+ File.separator + UPLOAD_DIR;
		request.setAttribute("path", uploadPhotoPath + File.separator
				+ customer.getIdCustomer() + ".JPG");

		gotoToJSP("customer/editProfile.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Customer current = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		
		Customer customer = new Customer();

		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));
		customer.setEmail(request.getParameter("email"));
		customer.setActive(current.getActive());

		customer.setIdCustomer(current.getIdCustomer());

		getCommonService().update(customer);

		doGet(request, response);

	}
}
