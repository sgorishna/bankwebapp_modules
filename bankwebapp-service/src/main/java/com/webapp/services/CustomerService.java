package com.webapp.services;

import java.util.List;

import com.webapp.model.Customer;

public interface CustomerService {

	Customer findById(long IdCustomer);
	
	Customer findByLogin(String login);

	Customer findByEmail(String email);

	void create(Customer customer);
	
	void updateImage(Customer customer);
	
	void update(Customer customer);

	void delete(Customer customer);

	long findIdCustomerByIdAccount(long idAccount);

	void activateProfile(long idCustomer);

	void deactivateProfile(long idCustomer);
	
	void clearHash(long idCustomer);
	
	void deleteUnverifiedProfiles();
	
	List<Customer> findAll();
}
