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

import com.universalcopy.p_integrador.model.CustomizationType;
import com.universalcopy.p_integrador.service.CustomizationTypeService;

@RestController
@RequestMapping("/api/customization-types")
public class CustomizationTypeController {
	
	private final CustomizationTypeService customizationTypeService;
	
	public CustomizationTypeController(CustomizationTypeService customizationTypeService) {
		this.customizationTypeService = customizationTypeService;
	}//Constructor
	
	@GetMapping
	public List<CustomizationType> getCustomizationTypes() {
		return customizationTypeService.getCustomizationTypes();
	}//getCustomizationTypes
	
	@GetMapping("/{ctypeid}")
	public CustomizationType getCustomizationType(@PathVariable("ctypeid") long id) {
		return customizationTypeService.getCustomizationType(id);
	}//getCustomizationType
	
	@PostMapping
	public CustomizationType addCustomizationType(@RequestBody CustomizationType category) {
		return customizationTypeService.addCustomizationType(category);
	}//addCustomizationType
	
	@DeleteMapping("/{ctypeid}")
	public CustomizationType deleteCustomizationType(@PathVariable("ctypeid") long id) {
		return customizationTypeService.deleteCustomizationType(id);
	}//deleteCustomizationType
	
	@PutMapping("/{ctypeid}")
	public CustomizationType updateCustomizationType(@PathVariable("ctypeid") long id,
			@RequestParam(name="name", required = false) String name) {
		return customizationTypeService.updateCustomizationType(id, name);
	}//updateCustomizationType
	
}//Class CustomizationTypeController
