package com.dot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.app.model.Customer;
import com.dot.app.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerRepo.findById(id).get();
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepo.deleteById(id);
	}

	@Override
	public int saveCustomer(Customer customer) {
		customerRepo.save(customer);
		return customer.getId();
	}
}
