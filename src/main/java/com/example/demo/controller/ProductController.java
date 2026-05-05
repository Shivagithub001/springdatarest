package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductsDao;
import com.example.demo.model.Products;

@RestController
public class ProductController {

	@Autowired
	private ProductsDao pdao;
	
	@GetMapping(path="/products")
	public List<Products> getProducts() {
		
		System.out.println("welcome to the products controller mapping method");
		return pdao.findAll();
	}
	
	@DeleteMapping("/deleteproduct/{pid}")
	public String deleteProduct(@PathVariable("pid") int pid) {
		
		Products p = pdao.getOne(pid);
		pdao.delete(p);
		return "you record deleted successfully";
		
	}

	@PutMapping("/updateproduct")
	public Products updateProduct(@RequestBody Products product) {
		
		return pdao.save(product);
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
