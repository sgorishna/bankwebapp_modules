package com.webapp.utils;

import java.math.BigDecimal;


import com.webapp.services.ExchangeRatesService;

public class TransactionHelper {

	
	
	public static BigDecimal getExchangeRate(long idFirstCurrency, long idSecondCurrency, ExchangeRatesService ratesService ){
		
	if(idFirstCurrency == idSecondCurrency){
		
		return new BigDecimal(1);
	}
	else{
		
		BigDecimal rateFrom = ratesService.findById(idFirstCurrency).getSell();
		BigDecimal rateTo = ratesService.findById(idSecondCurrency).getSell();
		
		return rateFrom.divide(rateTo);
	}
		
	}
}
