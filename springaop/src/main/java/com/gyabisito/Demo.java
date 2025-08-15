package com.gyabisito;

import com.gyabisito.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ProductService productService= context.getBean("productService",ProductService.class);
        System.out.println(productService.multiply(4,5));
    }
}
