package com.universalcopy.p_integrador.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.Product;
import com.universalcopy.p_integrador.repository.ProductRepository;



@Service
public class ProductService {
	
	private final ProductRepository repository;
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public List<Product> getProducts() {
		return repository.findAll();
	}//getAllProducts
	
	public Product getProduct(Long id) {
		return repository.findById(id)
				.orElseThrow( () -> new IllegalArgumentException("El producto con el id[" + "] no existe.") );
	}//getProduct
	
	public Product addProduct(Product product) {
		Optional<Product> prod = repository.findByName(product.getName());
		if(prod.isEmpty()) {
			repository.save(product);
			return product;
		}//if empty
		return null;
	}//addProduct
	
	public Product deleteProduct(long id) {
		Product tmp = null;
		if(repository.existsById(id)) {
			tmp = repository.findById(id).get();
			repository.deleteById(id);
		}//if exist
		return tmp;
	}//deleteProduct
	
	public Product updateProduct(long id, String name, Double price, String description, String imageUrl, Integer stock, Date createdAt) {
		Product tmp = null;
			if(repository.existsById(id)) {
				Product prod = repository.findById(id).get();
				if(name!=null) prod.setName(name);
				if(price!=null) prod.setPrice(price);
				if(description!=null) prod.setDescription(description);
				if(imageUrl!=null) prod.setImageUrl(imageUrl);
				repository.save(prod);
				tmp=prod;
			}
		return tmp;
	}//updateProduct
	
	
}//Class ProductService
