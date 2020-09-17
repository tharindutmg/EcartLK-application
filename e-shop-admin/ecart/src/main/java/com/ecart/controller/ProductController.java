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

import com.ecart.domain.Product;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.ProductService;

/**
 * @author Tharindu   Feb 23, 2020
 *
 */
@CrossOrigin
@RestController
public class ProductController {
	
	public final String url = "/product";
	
	@Autowired
	public ProductService productService;
	
	@PostMapping(url)
	public CommonCustomResponce createUpdate(@RequestBody Product product) {
		return productService.createUpdate(product);
	}
	
	@GetMapping(url)
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping(value=url+"/{id}")
	public Product getById(@PathVariable(value = "id") Long id) {
		return productService.getById(id);
	}
	
	// Delete
	@DeleteMapping(url+"/{id}")
	public CommonCustomResponce delete(@PathVariable(value = "id") Long id) {
	    return productService.delete(id);
	}

}
