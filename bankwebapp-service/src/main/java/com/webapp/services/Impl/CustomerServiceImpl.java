package com.webapp.services.Impl;

import java.util.List;

import com.webapp.dao.CustomerDao;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.model.Customer;
import com.webapp.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = new CustomerDaoImpl();
	}

	public Customer findByLogin(String login) {
		
		return customerDao.findByLogin(login);
	}

	public Customer findByEmail(String email) {
		
		return customerDao.findByEmail(email);
	}

	public void create(Customer customer, String[] roles) {
		customerDao.create(customer, roles);
		
	}

	public void update(Customer customer, String[] selectedRoles) {
		customerDao.update(customer, selectedRoles);
		
	}

	public void updateImage(Customer customer) {
		customerDao.updateImage(customer);
		
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

	public long findIdCustomerByIdAccount(long idAccount) {
		
		return customerDao.findIdCustomerByIdAccount(idAccount);
	}

	public void activateProfile(long idCustomer) {
		customerDao.activateProfile(idCustomer);
		
	}

	public void deactivateProfile(long idCustomer) {
		customerDao.deactivateProfile(idCustomer);
		
	}

	public void clearHash(long idCustomer) {
		customerDao.clearHash(idCustomer);
		
	}

	public void deleteUnverifiedProfiles() {
		customerDao.deleteUnverifiedProfiles();
		
	}

	public Customer findById(long IdCustomer) {
		
		return customerDao.findById(IdCustomer);
	}

	public void create(Customer customer) {
		customerDao.create(customer);
		
	}

	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

	

}
