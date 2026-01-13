package com.universalcopy.p_integrador.controller;

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

import com.universalcopy.p_integrador.model.Category;
import com.universalcopy.p_integrador.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}//Constructor
	
	@GetMapping
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}//getProducts
	
	@GetMapping("/{catid}")
	public Category getCategory(@PathVariable("catid") long id) {
		return categoryService.getCategory(id);
	}//getProducts
	
	@PostMapping
	public Category addProduct(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}//addProduct
	
	@DeleteMapping("/{catid}")
	public Category deleteProduct(@PathVariable("catid") long id) {
		return categoryService.deleteCategory(id);
	}//DeleteMapping
	
	@PutMapping("/{catid}")
	public Category updateProduct(@PathVariable("catid") long id,
			@RequestParam(name="name", required = false) String name) {
		return categoryService.updateCategory(id, name);
	}//updateProduct
	
}//Class CategoryController
