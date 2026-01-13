package com.universalcopy.p_integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.Category;
import com.universalcopy.p_integrador.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository repository;
	
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}//Constructor
	
	public List<Category> getCategories() {
		return repository.findAll();
	}//getAllCategories
	
	public Category getCategory(Long id) {
		return repository.findById(id)
				.orElseThrow( () -> new IllegalArgumentException("La categoría con el id [" + "] no existe.") );
	}//getCategory
	
	public Category addCategory(Category category) {
		Optional<Category> cat = repository.findByName(category.getName());
		if(cat.isEmpty()) {
			repository.save(category);
			return category;
		}//if empty
		return null;
	}//addCategory
	
	public Category deleteCategory(Long id) {
		Category tmp = null;
		if(repository.existsById(id)) {
			tmp = repository.findById(id).get();
			repository.deleteById(id);
		}//if exists
		return tmp;
	}//deleteProduct
	
	public Category updateCategory(long id, String name) {
		Category tmp = null;
		if(repository.existsById(id)) {
			Category cat = repository.findById(id).get();
			if(name!=null) cat.setName(name);
			repository.save(cat);
			tmp=cat;
		}//if exists
		return tmp;
	}//updateCategory
	
}//Class CategoryService
