package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;


@WebServlet("/admin/activateProfile")
public class ActivateProfileController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Long idCustomer = Long.parseLong(request.getParameter("idCustomer"));

		
		Customer c = getCommonService().findById(idCustomer);
		
		if(c.getHash() !=null){
			
			getCommonService().clearHash(idCustomer);
		}
		
		
		getAdminService().activateProfile(idCustomer);

		redirectRequest("/admin/customerList.php",
				request, response);
	}

}
