package com.universalcopy.p_integrador.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.model.Product;
import com.universalcopy.p_integrador.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}//Constructor
	
	
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}//getProducts
	
	@GetMapping("/{prodid}")
	public Product getProduct(@PathVariable("prodid") long id) {
		return productService.getProduct(id);
	}//getProducts
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}//addProduct
	
	@DeleteMapping("/{prodid}")
	public Product deleteProduct(@PathVariable("prodid") long id) {
		return productService.deleteProduct(id);
	}//DeleteMapping
	
	@PutMapping("/{prodid}")
	public Product updateProduct(@PathVariable("prodid") long id,
			@RequestParam(name="name", required = false) String name,
			@RequestParam(name="price", required = false) Double price,
			@RequestParam(name="description", required = false) String description,
			@RequestParam(name="imageUrl", required = false) String imageUrl,
			@RequestParam(name="stock", required = false) Integer stock,
			@RequestParam(name="createdAt", required = false) Date createdAt) {
		return productService.updateProduct(id, name, price, description, imageUrl, stock, createdAt);
	}//updateProduct
			
			
	
}//Class ProductController
