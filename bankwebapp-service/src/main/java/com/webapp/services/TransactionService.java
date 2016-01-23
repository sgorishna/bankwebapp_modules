package com.webapp.services;

import java.util.List;

import com.webapp.model.Account;
import com.webapp.model.Transaction;

public interface TransactionService {

List<Transaction> findByIdCustomer(long idCustomer);
	
	List<Transaction> findByIdAccount(long idAccount);
	
	void topUpBalance(Transaction transaction);
	
	void withdrawBalance(Transaction transaction);
	
	List<Transaction> transferredFundsByIdAccount(long idAccount);
	List<Transaction> receivedFundsByIdAccount(long idAccount);
	
	void transferFunds(Transaction transaction);
}
