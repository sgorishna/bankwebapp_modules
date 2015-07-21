package com.webapp.services.Impl;

import java.util.List;

import com.webapp.dao.AccountDao;
import com.webapp.dao.TransactionDao;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Transaction;
import com.webapp.services.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	private static TransactionDao transactionDao;
	private static AccountDao accountDao;

	public TransactionServiceImpl() {
		this.transactionDao = new TransactionDaoImpl();
		this.accountDao = new AccountDaoImpl();
	}

	public List<Transaction> findByIdCustomer(long idCustomer) {

		return transactionDao.findByIdCustomer(idCustomer);
	}

	public Account getAccountByAccountNumber(long accountNumber) {

		return accountDao.getAccountByAccountNumber(accountNumber);
	}

	public void create(Transaction transaction) {
		transactionDao.create(transaction);

	}

}
