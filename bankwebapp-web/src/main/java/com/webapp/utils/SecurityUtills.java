package com.webapp.utils;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;




import javax.servlet.http.HttpServletRequest;

import com.webapp.model.Customer;
import com.webapp.services.CustomerService;

public class SecurityUtills {
	
	public static boolean iskRequestedIdAccEqualCurrentIdCustomer(HttpServletRequest request, CustomerService service, String idAccount){

		Customer current = (Customer) request.getSession().getAttribute(
				CURRENT_SESSION_ACCOUNT);

		
		long idCustomer = service.findIdCustomerByIdAccount(
				Long.parseLong(idAccount));
		
		if (idCustomer == current.getIdCustomer()) {
			
			return true;
		}else return false;
		
	}

}
