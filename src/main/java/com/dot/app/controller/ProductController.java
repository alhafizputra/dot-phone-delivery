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

import com.dot.app.model.Product;
import com.dot.app.repo.ProductRepo;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	// creating a get mapping that retrieves all the products detail from the
	// database
	@GetMapping()
	private List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	// creating a get mapping that retrieves the detail of a specific product
	@GetMapping("/{id}")
	private Product getProduct(@PathVariable("id") int id) {
		return productRepo.findById(id).get();
	}

	// creating a delete mapping that deletes a specific product
	@DeleteMapping("/{id}")
	private void deleteProduct(@PathVariable("id") int id) {
		productRepo.deleteById(id);
	}

	// creating post mapping that post the product detail in the database
	@PostMapping()
	private int saveProduct(@RequestBody Product product) {
		productRepo.save(product);
		return product.getId();
	}
}
