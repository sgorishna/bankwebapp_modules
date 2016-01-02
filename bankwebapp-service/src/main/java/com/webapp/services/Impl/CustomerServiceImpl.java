package com.webapp.services.Impl;

import java.util.List;

import com.webapp.dao.CustomerDao;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerDao customerDao;

	public CustomerServiceImpl() {
		this.customerDao = new CustomerDaoImpl();
	}

	public List<Customer> findAll() {

		return customerDao.findAll();
	}

	public long findIdCustomerByIdAccount(long idAccount) {
		
		return customerDao.findIdCustomerByIdAccount(idAccount);
	}

}
