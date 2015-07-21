package com.webapp.services;

import java.util.List;

import com.webapp.model.Account;
import com.webapp.model.Transaction;

public interface TransactionService {

	List<Transaction> findByIdCustomer(long idCustomer);

	Account getAccountByAccountNumber(long accountNumber);

	void create(Transaction transaction);

}
