package com.gyabisito.springdatajpa.repos;

import com.gyabisito.springdatajpa.entity.Product;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository  extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);
    List<Product> findByNameAndPrice(String name, Double price);
}
