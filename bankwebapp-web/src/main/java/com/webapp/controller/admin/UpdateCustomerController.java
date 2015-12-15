package com.webapp.controller.admin;

import static com.webapp.utils.WebappConstants.UPLOAD_DIR;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

@MultipartConfig
public class UpdateCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = getCommonService().findById(IdCustomer);
		request.setAttribute("customer", customer);

		String applicationPath = request.getServletContext().getRealPath("");
		String uploadPhotoPath = applicationPath + File.separator + "recources" + File.separator + UPLOAD_DIR;
		request.setAttribute("path", uploadPhotoPath + File.separator + customer.getIdCustomer() + ".JPG");

		gotoToJSP("admin/updateCustomer3.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();
		// customer = request.getParameter("role");
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));
		customer.setEmail(request.getParameter("email"));

		// getAdminService().update(customer, selectedRoles);

		redirectRequest("/admin/updateCustomer.php?IdCustomer=" + Long.parseLong(request.getParameter("idCustomer")), request, response);

	}
}
