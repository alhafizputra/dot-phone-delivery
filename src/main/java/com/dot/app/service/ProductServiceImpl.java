package com.dot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.app.model.Product;
import com.dot.app.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProduct(int id) {
		return productRepo.findById(id).get();
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

	@Override()
	public int saveProduct(Product product) {
		productRepo.save(product);
		return product.getId();
	}
}
