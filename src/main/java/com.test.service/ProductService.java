package com.test.service;

import java.util.List;

import com.test.entity.Product;

public interface ProductService {
	public Product createProduct(Product pd);
	public List<Product> readAllProducts();
	public List<Product> updateProduct(Product pd);
	public List<Product> deleteProduct(int id);

}
