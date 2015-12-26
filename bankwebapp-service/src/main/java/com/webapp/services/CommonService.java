package com.webapp.services;

import java.util.List;

import com.webapp.model.Account;
import com.webapp.model.Customer;
import com.webapp.model.Role;
import com.webapp.model.Transaction;

public interface CommonService {

	List<Account> getAccountByIdCustomer(long idCustomer);

	//Account getAccountByAccountNumber(String accountNumber);

	Customer findById(long IdCustomer);

	Customer findByEmail(String email);

	List<Role> findAllRoles();

	void updateImage(Customer customer);
	
	void update(Customer customer);
	
	
	
	
}
