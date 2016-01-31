package com.webapp.services.Impl;

import java.math.BigDecimal;
import java.util.List;

import com.webapp.dao.ExchangeRateDao;
import com.webapp.model.ExchangeRate;
import com.webapp.services.ExchangeRatesService;

public class ExchangeRatesServiceImpl implements ExchangeRatesService {

	private ExchangeRateDao dao;
	
	public ExchangeRatesServiceImpl(ExchangeRateDao dao) {
		this.dao = dao; 
	}
	
	public List<ExchangeRate> findAll() {
		
		return dao.findAll();
	}

	public ExchangeRate findById(long id) {
		
		return dao.findById(id);
	}

	public void update(ExchangeRate exchangeRate) {
		dao.update(exchangeRate);
		
	}



}
