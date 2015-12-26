package com.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private long idAccount;
	private long idCustomer;
	private String сustomerName;
	private long idAccountType;
	private String accountType;
	private long idCurrency;
	private String сurrency;
	private String accountNumber;
	private BigDecimal balance;
	private Timestamp created;
	private Timestamp updated;
	
	private Integer active;

	public long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public long getIdAccountType() {
		return idAccountType;
	}

	public void setIdAccountType(long idAccountType) {
		this.idAccountType = idAccountType;
	}

	public long getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(long idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getCustomerName() {
		return сustomerName;
	}

	public void setCustomerName(String customerName) {
		this.сustomerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrency() {
		return сurrency;
	}

	public void setCurrency(String currency) {
		this.сurrency = currency;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
