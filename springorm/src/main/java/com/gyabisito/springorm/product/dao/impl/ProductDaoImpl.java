package com.gyabisito.springorm.product.dao.impl;

import com.gyabisito.springorm.product.dao.ProductDao;
import com.gyabisito.springorm.product.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public int create(Product product) {
		em.persist(product);
		return product.getId();
	}

	@Override
	public void update(Product product) {
		em.merge(product);
	}

	@Override
	public void delete(Product product) {
		Product managed = em.contains(product) ? product : em.find(Product.class, product.getId());
		if (managed != null) em.remove(managed);
	}

	@Override
	@Transactional(readOnly = true)
	public Product find(int id) {
		return em.find(Product.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}
}
