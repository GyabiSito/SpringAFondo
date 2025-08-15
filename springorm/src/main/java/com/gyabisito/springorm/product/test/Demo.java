package com.gyabisito.springorm.product.test;

import java.util.List;

import com.gyabisito.springorm.product.dao.service.ProductService;
import com.gyabisito.springorm.product.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/config.xml");
        ProductService productService = (ProductService) context.getBean("productService");

        productService.createAndDeleteCycle();

        List<Product> products = productService.getAll();
        System.out.println(products);
    }

}
