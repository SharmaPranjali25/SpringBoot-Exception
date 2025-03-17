package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	
	

	@Override
	public Product createProduct(Product pd) {
		try {
			if(pd!=null) {
				productDao.createProduct(pd);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public List<Product> readAllProducts() {
		List<Product> list=productDao.readAllProduct();
		if(list.size()<0) {
			System.out.println("no content");
		}
		return list;
	}

	@Override
	public List<Product> updateProduct(Product pd) {
		productDao.updateProduct(pd);
		return productDao.readAllProduct();
	}

	@Override
	public List<Product> deleteProduct(int id) {
		productDao.deleteProduct(id);
		return productDao.readAllProduct();
	}

}
