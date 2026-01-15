package com.universalcopy.p_integrador.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.universalcopy.p_integrador.model.CustomizationType;
import com.universalcopy.p_integrador.model.Product;
import com.universalcopy.p_integrador.model.ProductCustomization;
import com.universalcopy.p_integrador.repository.CustomizationTypeRepository;
import com.universalcopy.p_integrador.repository.ProductCustomizationRepository;
import com.universalcopy.p_integrador.repository.ProductRepository;

@Service
public class ProductCustomizationService {
	
    private final ProductCustomizationRepository productCustomizationRepository;
    private final ProductRepository productRepository;
    private final CustomizationTypeRepository customizationTypeRepository;
    
    
	public ProductCustomizationService(ProductCustomizationRepository productCustomizationRepository,
			ProductRepository productRepository, CustomizationTypeRepository customizationTypeRepository) {
		super();
		this.productCustomizationRepository = productCustomizationRepository;
		this.productRepository = productRepository;
		this.customizationTypeRepository = customizationTypeRepository;
	}//Constructor
    
	public List<ProductCustomization> getProductCustomizations() {
		return productCustomizationRepository.findAll();
	}//getProductCustomizations
	
	public ProductCustomization getProductCustomization(Long id) {
		return productCustomizationRepository.findById(id)
				.orElseThrow( () -> new IllegalArgumentException("La personalización de producto con el id [" + id + "] no existe." ) );
	}//getProductCustomization
	
	public ProductCustomization addProductCustomization(Long productId, Long customizationTypeId, ProductCustomization productCustomization) {
		Product product = productRepository.findById(productId)
				.orElseThrow( () -> new IllegalArgumentException("El producto con el id [" + productId + "] no existe") );
		CustomizationType customizationType = customizationTypeRepository.findById(customizationTypeId)
				.orElseThrow( () -> new IllegalArgumentException("El tipo de personalización con el id [" + productCustomization + "] no existe.") );
		productCustomization.setProduct(product);
		productCustomization.setCustomizationType(customizationType);
		
		return productCustomizationRepository.save(productCustomization);
		
	}//addProductCustomization
	
	public ProductCustomization deleteProductCustomization(Long id) {
		ProductCustomization tmp = null;
		if(productCustomizationRepository.existsById(id)) {
			tmp = productCustomizationRepository.findById(id).get();
			productCustomizationRepository.deleteById(id);
		}//if exists
		return tmp;
	}//deleteProductCustomization
	
}//Class ProductCustomizationService 
