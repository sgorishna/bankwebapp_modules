package com.webapp.services.Impl;

import java.math.BigDecimal;
import java.util.List;

import com.webapp.dao.AccountDao;
import com.webapp.model.Account;
import com.webapp.services.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;
	
	public AccountServiceImpl(AccountDao accountDao) {
		
		this.accountDao = accountDao;
	}

	public List<Account> getAccountByIdCustomer(long idCustomer) {
		
		return accountDao.getAccountByIdCustomer(idCustomer);
	}

	public void topUpBalance(Account account, BigDecimal amount) {
		accountDao.topUpBalance(account, amount);
		
	}

	public Account findByAccountNumber(String accountNumber) {
		
		return findByAccountNumber(accountNumber);
	}

	public void activateAccount(long idAccount) {
		
		accountDao.activateAccount(idAccount);
		
	}

	public void deactivateAccount(long idAccount) {
		accountDao.deactivateAccount(idAccount);
		
	}

	public List<Account> findAllAccounts() {
		
		return accountDao.findAll();
	}

	public Account findById(long id) {
		
		return accountDao.findById(id);
	}

	public void create(Account account) {
		accountDao.create(account);
		
	}

	public void delete(Account account) {
		accountDao.delete(account);
	}

}
