package com.example.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();
	

}
