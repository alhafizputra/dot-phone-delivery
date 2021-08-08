package com.dot.app.service;

import java.util.List;
import com.dot.app.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomer();
	Customer getCustomer(int id);
	void deleteCustomer(int id);
	int saveCustomer(Customer customer);
}
