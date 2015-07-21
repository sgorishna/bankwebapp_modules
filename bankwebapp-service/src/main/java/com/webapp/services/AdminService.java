package com.webapp.services;

import java.util.List;

import com.webapp.model.Account;
import com.webapp.model.Customer;

public interface AdminService {

	public void create(Account account);

	public void delete(Account object) throws UnsupportedOperationException;

	public void update(Account object) throws UnsupportedOperationException;

	List<Account> findAllAccounts();

	void delete(Customer customer);

	void create(Customer customer, String[] roles);

	void update(Customer customer, String[] selectedRoles);

}
