package com.webapp.services;

import java.math.BigDecimal;
import java.util.List;

import com.webapp.model.ExchangeRate;

public interface ExchangeRatesService {
	
	List<ExchangeRate> findAll();
	
	ExchangeRate findById(long id);

	void update(ExchangeRate exchangeRate);
	
	
}
