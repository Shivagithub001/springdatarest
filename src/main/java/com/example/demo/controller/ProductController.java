package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductsDao;
import com.example.demo.model.Products;

@RestController
public class ProductController {

	@Autowired
	private ProductsDao pdao;
	
	@GetMapping(path="/products",produces = {"application/xml"})
	public List<Products> getProducts() {
		
		System.out.println("welcome to the products controller mapping method");
		return pdao.findAll();
	}
	
	@GetMapping("/product/{pid}")
	public Optional<Products> getProduct(@PathVariable("pid") int pid) {
		
		return pdao.findById(pid);
	}
	
	@PostMapping("/saveproduct")
	public Products saveProduct(@RequestBody Products product) {
		
		return pdao.save(product);
	}
}
