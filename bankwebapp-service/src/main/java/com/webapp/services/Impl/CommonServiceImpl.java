package com.webapp.services.Impl;

import java.util.List;

import com.webapp.dao.AccountDao;
import com.webapp.dao.CustomerDao;
import com.webapp.dao.RoleDao;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.dao.impl.RoleDaoImpl;
import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.model.Role;
import com.webapp.services.CommonService;

public class CommonServiceImpl implements CommonService {

	private static AccountDao accountDao;

	private static CustomerDao customerDao;

	private static RoleDao roleDao;

	public CommonServiceImpl() {
		this.customerDao = new CustomerDaoImpl();
		this.accountDao = new AccountDaoImpl();
		this.roleDao = new RoleDaoImpl();

	}

	public Account getAccountByAccountNumber(long accountNumber) {

		return accountDao.getAccountByAccountNumber(accountNumber);
	}

	public Customer findById(long IdCustomer) {

		return customerDao.findById(IdCustomer);
	}

	public List<Account> getAccountByIdCustomer(long idCustomer) {

		return accountDao.getAccountByIdCustomer(idCustomer);
	}

	public List<Role> findAllRoles() {

		return roleDao.findAll();
	}

	public Customer findByEmail(String email) {

		return customerDao.findByEmail(email);
	}

	public void updateImage(Customer customer) {

		customerDao.updateImage(customer);

	}

	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

}
