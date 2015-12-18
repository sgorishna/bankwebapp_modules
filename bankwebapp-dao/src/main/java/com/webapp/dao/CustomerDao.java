package com.webapp.dao;

import java.io.Serializable;

import com.webapp.model.Customer;

public interface CustomerDao extends IEntityDao<Customer>, Serializable {

	Customer findByLogin(String login);

	Customer findByEmail(String email);

	void create(Customer customer, String[] roles);

	void update(Customer customer, String[] selectedRoles);

	void updateImage(Customer customer);

	void delete(Customer customer);
	
	

}
