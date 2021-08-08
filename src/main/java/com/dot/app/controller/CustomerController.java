package com.dot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dot.app.model.Customer;
import com.dot.app.repo.CustomerRepo;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	// creating a get mapping that retrieves all the customers detail from the
	// database
	@GetMapping()
	private List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	// creating a get mapping that retrieves the detail of a specific customer
	@GetMapping("/{id}")
	private Customer getCustomer(@PathVariable("id") int id) {
		return customerRepo.findById(id).get();
	}

	// creating a delete mapping that deletes a specific customer
	@DeleteMapping("/{id}")
	private void deleteCustomer(@PathVariable("id") int id) {
		customerRepo.deleteById(id);
	}

	// creating post mapping that post the customer detail in the database
	@PostMapping()
	private int saveCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return customer.getId();
	}
}
