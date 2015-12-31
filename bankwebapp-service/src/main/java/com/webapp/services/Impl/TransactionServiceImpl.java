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

	

	public void create(Transaction transaction) {
		transactionDao.create(transaction);

	}

	public void topUpBalance(Transaction transaction) {
		 
		transactionDao.topUpBalance(transaction);
		
	}

	public Account findByAccountNumber(String accountNumber) {
		
		return accountDao.findByAccountNumber(accountNumber);
	}

	public void withdrawBalance(Transaction transaction) {
		
		transactionDao.withdrawBalance(transaction);
	}

	public List<Transaction> findByIdAccount(long idAccount) {
		
		return transactionDao.findByIdAccount(idAccount);
	}

	public List<Transaction> transferredFundsByIdAccount(long idAccount) {
		
		return transactionDao.transferredFundsByIdAccount(idAccount);
	}

	public List<Transaction> receivedFundsByIdAccount(long idAccount) {
		
		return transactionDao.receivedFundsByIdAccount(idAccount);
	}

	


}
