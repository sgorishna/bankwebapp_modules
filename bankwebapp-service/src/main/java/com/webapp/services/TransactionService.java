package com.webapp.services;

import java.util.List;

import com.webapp.model.Account;
import com.webapp.model.Transaction;

public interface TransactionService {

	List<Transaction> findByIdCustomer(long idCustomer);

	Account findByAccountNumber(String accountNumber);

	void create(Transaction transaction);

	 void topUpBalance(Transaction transaction);
	 
	 void withdrawBalance(Transaction transaction);
}
