package com.webapp.services;

import java.util.List;

import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.model.Role;

public interface CommonService {

	List<Account> getAccountByIdCustomer(long idCustomer);

	Account getAccountByAccountNumber(long accountNumber);

	Customer findById(long IdCustomer);

	Customer findByEmail(String email);

	List<Role> findAllRoles();

	void updateImage(Customer customer);
	
	void update(Customer customer);
	
	
}
