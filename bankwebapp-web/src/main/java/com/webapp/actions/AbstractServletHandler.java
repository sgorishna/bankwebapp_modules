package com.webapp.actions;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.services.AdminService;
import com.webapp.services.CommonService;
import com.webapp.services.CustomerService;
import com.webapp.services.DataService;
import com.webapp.services.TransactionService;
import com.webapp.services.Impl.AdminServiceImpl;
import com.webapp.services.Impl.CommonServiceImpl;
import com.webapp.services.Impl.CustomerServiceImpl;
import com.webapp.services.Impl.DataServiceImpl;
import com.webapp.services.Impl.TransactionServiceImpl;

public abstract class AbstractServletHandler extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	private static AdminService adminService;
	private static CommonService commonService;
	private static CustomerService customerService;

	private static TransactionService transactionService;

	private static DataService dataService;

	public AbstractServletHandler() {

		AbstractServletHandler.setAdminService(new AdminServiceImpl());
		AbstractServletHandler.setCommonService(new CommonServiceImpl());
		AbstractServletHandler.setCustomerService(new CustomerServiceImpl());
		AbstractServletHandler.setTransactionService(new TransactionServiceImpl());
		AbstractServletHandler.setDataService(new DataServiceImpl());

	}

	protected final void gotoToJSP(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/recources/JSP/" + page).forward(request, response);
	}

	protected final void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	public static AdminService getAdminService() {
		return adminService;
	}

	public static void setAdminService(AdminService adminService) {
		AbstractServletHandler.adminService = adminService;
	}

	public static CommonService getCommonService() {
		return commonService;
	}

	public static void setCommonService(CommonService commonService) {
		AbstractServletHandler.commonService = commonService;
	}

	public static CustomerService getCustomerService() {
		return customerService;
	}

	public static void setCustomerService(CustomerService customerService) {
		AbstractServletHandler.customerService = customerService;
	}

	public static TransactionService getTransactionService() {
		return transactionService;
	}

	public static void setTransactionService(TransactionService transactionService) {
		AbstractServletHandler.transactionService = transactionService;
	}

	public static DataService getDataService() {
		return dataService;
	}

	public static void setDataService(DataService dataService) {
		AbstractServletHandler.dataService = dataService;
	}

}
