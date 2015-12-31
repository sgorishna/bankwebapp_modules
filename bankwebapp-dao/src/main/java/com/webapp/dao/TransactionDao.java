package com.webapp.dao;

import java.io.Serializable;
import java.util.List;

import com.webapp.model.Transaction;

public interface TransactionDao extends IEntityDao<Transaction>, Serializable {

	List<Transaction> findByIdCustomer(long idCustomer);
	
	List<Transaction> findByIdAccount(long idAccount);
	
	void topUpBalance(Transaction transaction);
	
	void withdrawBalance(Transaction transaction);
	
	List<Transaction> transferredFundsByIdAccount(long idAccount);
	List<Transaction> receivedFundsByIdAccount(long idAccount);
	

}
