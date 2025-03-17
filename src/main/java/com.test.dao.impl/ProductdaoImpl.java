package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.repository.ProductRepository;


@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private ProductRepository repository;
	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}
	
	

	@Override
	public Product createProduct(Product pd) {
		return repository.save(pd);
	}

	@Override
	public List<Product> readAllProduct() {
		return repository.findAll();
	}

	@Override
	public List<Product> updateProduct(Product pd) {
		repository.save(pd);
		return repository.findAll();
	}

	@Override
	public List<Product> deleteProduct(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}

}
