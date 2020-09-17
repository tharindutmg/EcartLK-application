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

import com.ecart.domain.Discount;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.DiscountService;

/**
 * @author Tharindu   Mar 5, 2020
 *
 */
@CrossOrigin
@RestController
public class DiscountController {
	
public final String url = "/discount";
	
	@Autowired
	public DiscountService discountService;
	
	@PostMapping(url)
	public CommonCustomResponce createUpdate(@RequestBody Discount discount) {
		return discountService.createUpdate(discount);
	}
	
	@GetMapping(url)
	public List<Discount> getAll() {
		return discountService.getAll();
	}
	
	@GetMapping(value=url+"/{id}")
	public Discount getById(@PathVariable(value = "id") Long id) {
		return discountService.getById(id);
	}
	
	// Delete
	@DeleteMapping(url+"/{id}")
	public CommonCustomResponce delete(@PathVariable(value = "id") Long id) {
	    return discountService.delete(id);
	}
	
	
	
	@GetMapping(value=url+"/itemId/{id}")
	public List<Discount> getDiscountsById(@PathVariable(value = "id") Long id) {
		return discountService.getDiscountsById(id);
	}

}
