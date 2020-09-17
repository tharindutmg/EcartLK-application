/**
 * 
 */
package com.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.model.NavigationModel;
import com.ecart.searvice.NavigationService;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@CrossOrigin
@RestController
public class NavigationController {
	@Autowired
	private NavigationService navigationService; 
	
	@GetMapping("/navigation")
	public List<NavigationModel> getNavigation() {
		return navigationService.getNavigation();
		
	}

}
