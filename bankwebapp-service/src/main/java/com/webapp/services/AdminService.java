package com.webapp.services;

import java.util.List;

import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Account;
import com.webapp.model.Customer;

public interface AdminService {

	public void create(Account account);

	public void delete(Account object) throws UnsupportedOperationException;

	public void update(Account object) throws UnsupportedOperationException;

	List<Account> findAllAccounts();

	void delete(Customer customer);

	void create(Customer customer, String[] roles) throws InvalidDataException;

	void update(Customer customer, String[] selectedRoles);

	void create(Customer customer) throws InvalidDataException;

	public Customer findByLogin(String login);

}
