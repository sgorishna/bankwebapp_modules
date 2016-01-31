package com.webapp.model;

import java.math.BigDecimal;

public class ExchangeRate {
	
	
	
	private long idCurrency;
	
	private String currency;
	
	private BigDecimal buy;
	
	private BigDecimal sell;

	public long getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(long idCurrency) {
		this.idCurrency = idCurrency;
	}

	public BigDecimal getBuy() {
		return buy;
	}

	public void setBuy(BigDecimal buy) {
		this.buy = buy;
	}

	public BigDecimal getSell() {
		return sell;
	}

	public void setSell(BigDecimal sell) {
		this.sell = sell;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	

	
}
