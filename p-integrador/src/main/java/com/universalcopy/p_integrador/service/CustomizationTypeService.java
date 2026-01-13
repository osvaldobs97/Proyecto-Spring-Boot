package com.universalcopy.p_integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.CustomizationType;
import com.universalcopy.p_integrador.repository.CustomizationTypeRepository;

@Service
public class CustomizationTypeService {
	
	private final CustomizationTypeRepository repository;
	
	public CustomizationTypeService(CustomizationTypeRepository repository) {
		this.repository = repository;
	}//Constructor
	
	public List<CustomizationType> getCustomizationTypes() {
		return repository.findAll();
	}//getCustomizationTypes
	
	public CustomizationType getCustomizationType(Long id) {
		return repository.findById(id)
				.orElseThrow( () -> new IllegalArgumentException("El tipo de personalización con el id [" + "] no existe.") );
	}//getCustomizationType
	
	public CustomizationType addCustomizationType(CustomizationType customizationType) {
		Optional<CustomizationType> cat = repository.findByName(customizationType.getName());
		if(cat.isEmpty()) {
			repository.save(customizationType);
			return customizationType;
		}//if empty
		return null;
	}//addCustomizationType
	
	public CustomizationType deleteCustomizationType(Long id) {
		CustomizationType tmp = null;
		if(repository.existsById(id)) {
			tmp = repository.findById(id).get();
			repository.deleteById(id);
		}//if exists
		return tmp;
	}//deleteCustomizationType
	
	public CustomizationType updateCustomizationType(long id, String name) {
		CustomizationType tmp = null;
		if(repository.existsById(id)) {
			CustomizationType cat = repository.findById(id).get();
			if(name!=null) cat.setName(name);
			repository.save(cat);
			tmp=cat;
		}//if exists
		return tmp;
	}//updateCustomizationType
	
}//Class CustomizationTypeService
