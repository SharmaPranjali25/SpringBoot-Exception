package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Product;
import com.test.service.ProductService;

@RestController
@RequestMapping("product/v1")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product pd) {
		Product prObj=service.createProduct(pd);
		return new ResponseEntity<>(prObj, HttpStatus.CREATED);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<List<Product>> listAllCustomers(){
		List <Product> listPr=service.readAllProducts();
		return new ResponseEntity<>(listPr, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<List<Product>> updateProduct(@RequestBody Product pd, @PathVariable("id") int id){
		pd.setId(id);
		List <Product> listPro=service.updateProduct(pd);
		return new ResponseEntity<>(listPro, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") int id){
		List <Product> listPrd=service.deleteProduct(id);
		return new ResponseEntity<>(listPrd, HttpStatus.ACCEPTED);
	}

	

}
