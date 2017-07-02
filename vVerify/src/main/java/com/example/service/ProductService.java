package com.example.service;

import java.util.List;

import com.example.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts();

	Product getProduct(String productId);

	Product createProduct(Product product);

}
