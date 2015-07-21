package com.webapp.services;

import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;

public interface DataService {

	Customer login(String login, String password, Integer role) throws InvalidDataException;
}
