package com.dot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dot.app.model.Product;

@Repository()
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
}
