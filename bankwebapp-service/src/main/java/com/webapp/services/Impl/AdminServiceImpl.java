package com.webapp.services.Impl;

import java.util.List;

import com.webapp.dao.AccountDao;
import com.webapp.dao.CustomerDao;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Account;
import com.webapp.model.Customer;
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

	public void delete(Account object) throws UnsupportedOperationException {
		accountDao.delete(object);

	}

	public void update(Account object) throws UnsupportedOperationException {
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

}
