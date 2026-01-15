package com.universalcopy.p_integrador.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.model.ProductCustomization;
import com.universalcopy.p_integrador.service.ProductCustomizationService;

@RestController
@RequestMapping("/api/product-customizations")
public class ProductCustomizationController {
	
	private final ProductCustomizationService productCustomizationService;
	
	public ProductCustomizationController(ProductCustomizationService productCustomizationService) {
		this.productCustomizationService = productCustomizationService;
	}//Constructor
	
	@GetMapping
	public List<ProductCustomization> getProductCustomizations() {
		return productCustomizationService.getProductCustomizations();
	}//getCustomizationTypes
	
	@GetMapping("/{prodcustid}")
	public ProductCustomization getProductCustomization(@PathVariable("prodcustid") long id) {
		return productCustomizationService.getProductCustomization(id);
	}//getCustomizationType
	
	@PostMapping
	public ProductCustomization addProductCustomization(
			@RequestParam Long productId,
			@RequestParam Long customizationTypeId,
			@RequestBody ProductCustomization productCustomization) {
		return productCustomizationService.addProductCustomization(productId, customizationTypeId, productCustomization);
	}//addCustomizationType
	
	@DeleteMapping("/{ctypeid}")
	public ProductCustomization deleteProductCustomization(@PathVariable("ctypeid") long id) {
		return productCustomizationService.deleteProductCustomization(id);
	}//deleteCustomizationType
	
}//ProductCustomizationController
