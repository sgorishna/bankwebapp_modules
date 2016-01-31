package com.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idTransaction;

	private long idAccountSender;

	private long idAccountReceiver;

	private String senderAccountNumber;

	private String receiverAccountNumber;

	private String senderName;

	private String receiverName;

	private String currency;

	private BigDecimal amount;
	
	private BigDecimal amountAfterConversion;

	private String comments;

	private Timestamp created;

	public long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public long getIdAccountSender() {
		return idAccountSender;
	}

	public void setIdAccountSender(long idAccountSender) {
		this.idAccountSender = idAccountSender;
	}

	public long getIdAccountReceiver() {
		return idAccountReceiver;
	}

	public void setIdAccountReceiver(long idAccountReceiver) {
		this.idAccountReceiver = idAccountReceiver;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(String senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public String getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(String receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getAmountAfterConversion() {
		return amountAfterConversion;
	}

	public void setAmountAfterConversion(BigDecimal amountAfterConversion) {
		this.amountAfterConversion = amountAfterConversion;
	}

}
