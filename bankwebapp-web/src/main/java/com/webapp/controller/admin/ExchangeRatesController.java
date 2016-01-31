package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.ExchangeRateDaoImpl;
import com.webapp.services.AccountService;
import com.webapp.services.ExchangeRatesService;
import com.webapp.services.Impl.AccountServiceImpl;
import com.webapp.services.Impl.ExchangeRatesServiceImpl;

@WebServlet("/admin/exchangeRates")
public class ExchangeRatesController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;
	
	ExchangeRatesService service = new ExchangeRatesServiceImpl(new ExchangeRateDaoImpl());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("rates", service.findAll());
		
		gotoToJSP("admin/exchangeRates.jsp", request, response);
	}

}
