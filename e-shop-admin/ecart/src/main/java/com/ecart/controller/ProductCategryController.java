/**
 * 
 */
package com.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.domain.AccessGroupMap;
import com.ecart.domain.AccessGroups;
import com.ecart.domain.ProductCategory;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.ProductCategoryService;

/**
 * @author Tharindu   Feb 19, 2020
 *
 */

@CrossOrigin
@RestController
public class ProductCategryController {
	
	public final String url = "/product-category";
	
	@Autowired
	public ProductCategoryService productCategoryService;
	
	@PostMapping(url)
	public CommonCustomResponce createUpdate(@RequestBody ProductCategory productCategory) {
		return productCategoryService.createUpdate(productCategory);
	}
	
	@GetMapping(url)
	public List<ProductCategory> getAll() {
		return productCategoryService.getAll();
	}
	
	@GetMapping(value=url+"/{id}")
	public ProductCategory getById(@PathVariable(value = "id") Long id) {
		return productCategoryService.getById(id);
	}
	
	// Delete
	@DeleteMapping(url+"/{id}")
	public CommonCustomResponce delete(@PathVariable(value = "id") Long id) {
	    return productCategoryService.delete(id);
	}
	

}
