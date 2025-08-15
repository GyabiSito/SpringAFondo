package com.gyabisito.springdatajpa;

import com.gyabisito.springdatajpa.entity.Product;
import com.gyabisito.springdatajpa.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringdatajpaApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
//        productRepository.save(new Product(2,"pepe","asd",213));
        List<Product> product=productRepository.findByNameAndPrice("pepe", 213.0);
        System.out.println(product);



    }

}
