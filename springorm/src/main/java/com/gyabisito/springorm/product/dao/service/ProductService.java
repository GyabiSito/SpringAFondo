package com.gyabisito.springorm.product.dao.service;

import com.gyabisito.springorm.product.dao.ProductDao;
import com.gyabisito.springorm.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void createAndDeleteCycle() {
        Product product = new Product();
        product.setId(1);
        product.setName("Iphone");
        product.setDesc("Its awesome!!");
        product.setPrice(800);

        productDao.create(product);
//        productDao.update(product);
//        productDao.delete(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productDao.findAll();
    }
}
