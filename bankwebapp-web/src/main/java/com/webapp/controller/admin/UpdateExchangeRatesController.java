package com.webapp.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.ExchangeRateDaoImpl;
import com.webapp.model.ExchangeRate;
import com.webapp.services.ExchangeRatesService;
import com.webapp.services.Impl.ExchangeRatesServiceImpl;

@WebServlet("/admin/updateExchangeRates")
public class UpdateExchangeRatesController extends AbstractServletHandler {

	ExchangeRatesService service = new ExchangeRatesServiceImpl(new ExchangeRateDaoImpl());
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		int idPair = Integer.parseInt(req.getParameter("id"));
		
		ExchangeRate er = service.findById(idPair);
		
		req.setAttribute("rates", er);
		
		gotoToJSP("admin/updateExchangeRates.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int idCurrency = Integer.parseInt(req.getParameter("id"));
		
		BigDecimal buy = new BigDecimal(req.getParameter("buy"));
		BigDecimal sell = new BigDecimal(req.getParameter("sell"));
		
		ExchangeRate exchangeRate = new ExchangeRate();
		
		exchangeRate.setIdCurrency(idCurrency);
		
		exchangeRate.setBuy(buy);
		
		exchangeRate.setSell(sell);
		
		service.update(exchangeRate);
		
		redirectRequest("/admin/exchangeRates", req, resp);
	}

}
