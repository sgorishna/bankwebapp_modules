package com.webapp.services.Impl;

import java.util.List;

import com.webapp.dao.AccountDao;
import com.webapp.dao.CustomerDao;
import com.webapp.dao.TransactionDao;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.model.Transaction;
import com.webapp.services.AdminService;

public class AdminServiceImpl implements AdminService {

	private static AccountDao accountDao;

	private static CustomerDao customerDao;
	
	

	public AdminServiceImpl() {

		this.accountDao = new AccountDaoImpl();
		this.customerDao = new CustomerDaoImpl();
		
		

	}

	public void create(Account account) {

		accountDao.create(account);
	}

	public void delete(Account object) {
		accountDao.delete(object);

	}

	public void update(Account object)  {
		accountDao.update(object);
	}

	public List<Account> findAllAccounts() {

		return accountDao.findAll();
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);

	}

	public void create(Customer customer, String[] roles) throws InvalidDataException {
		customerDao.create(customer, roles);

	}

	public void update(Customer customer, String[] selectedRoles) {
		customerDao.update(customer, selectedRoles);

	}

	public void create(Customer customer) throws InvalidDataException {
		customerDao.create(customer);

	}

	public Customer findByLogin(String login) {

		return customerDao.findByLogin(login);
	}

	public Account findByAccountNumber(String accountNumber) {
		
		return accountDao.findByAccountNumber(accountNumber);
	}

	public Account findById(long idAccount) {
		
		return  accountDao.findById(idAccount);
	}

	public void activateAccount(long idAccount) {
		accountDao.activateAccount(idAccount);
		
	}

	public void deactivateAccount(long idAccount) {
		accountDao.deactivateAccount(idAccount);
		
	}


}
