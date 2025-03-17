package com.test.dao;

import java.util.List;

import com.test.entity.Product;

public interface ProductDao {
public Product createProduct(Product pd);
	
	public List<Product> readAllProduct();
	
	public List<Product> updateProduct(Product pd);
	
	public List<Product> deleteProduct(int id);

}
