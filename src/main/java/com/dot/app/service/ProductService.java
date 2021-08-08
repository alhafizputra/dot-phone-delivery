package com.dot.app.service;

import java.util.List;
import com.dot.app.model.Product;

public interface ProductService {
	List<Product> getAllProduct();
	Product getProduct(int id);
	void deleteProduct(int id);
	int saveProduct(Product Product);
}
