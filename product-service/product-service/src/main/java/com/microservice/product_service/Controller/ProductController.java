package com.microservice.product_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product_service.Entity.Product;
import com.microservice.product_service.Repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product ) {
		productRepository.save(product);
		return product ;
	}	
	@GetMapping
	public List<Product> getallproduct(){
		return productRepository.findAll();
	}
	@GetMapping("/{productid}")
	public ResponseEntity<Product> getProductById(@PathVariable("productid") Long productID ) {
		Product product = productRepository.findById(productID).orElseThrow(()->new RuntimeException("product Not Found " +productID));
		return ResponseEntity.ok(product);
	}

}
