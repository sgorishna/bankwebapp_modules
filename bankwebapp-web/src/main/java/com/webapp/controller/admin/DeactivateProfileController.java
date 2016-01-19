package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;


@WebServlet("/admin/deactivateProfile")
public class DeactivateProfileController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Long idCustomer = Long.parseLong(request.getParameter("idCustomer"));

		

		getAdminService().deactivateProfile(idCustomer);

		redirectRequest("/admin/customerList.php", request, response);
	}

}
