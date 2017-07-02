package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Product;
import com.example.repository.ProductRepository;

@Component
@Transactional
class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(String productId) {
		return repository.findOne(Long.valueOf(productId));
	}

	@Override
	public Product createProduct(Product product) {
		repository.save(product);
		return product;
	}

}
