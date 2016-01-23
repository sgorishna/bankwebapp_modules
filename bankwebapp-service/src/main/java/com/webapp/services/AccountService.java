package com.webapp.services;

import java.math.BigDecimal;
import java.util.List;

import com.webapp.model.Account;

public interface AccountService {

	List<Account> getAccountByIdCustomer(long idCustomer);

	void topUpBalance(Account account, BigDecimal amount);

	Account findByAccountNumber(String accountNumber);

	void activateAccount(long idAccount);

	void deactivateAccount(long idAccount);
	
	List<Account> findAllAccounts();
	
	Account findById(long id);
	
	void create(Account account);
	
	void delete(Account account);
	

}
