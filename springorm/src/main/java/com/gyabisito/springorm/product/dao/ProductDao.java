package com.gyabisito.springorm.product.dao;

import com.gyabisito.springorm.product.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductDao {

	int create(Product product);

	void update(Product product);

	void delete(Product product);

	Product find(int id);

	List<Product> findAll();


}
